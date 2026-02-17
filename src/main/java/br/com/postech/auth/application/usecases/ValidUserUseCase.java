package br.com.postech.auth.application.usecases;

import br.com.postech.auth.adapter.in.rest.dto.RequestLoginDto;
import br.com.postech.auth.adapter.in.rest.dto.TokenResponse;
import br.com.postech.auth.domain.exception.LoginSenhaInvalidoException;
import br.com.postech.auth.domain.ports.in.ValidUserPortIn;
import br.com.postech.auth.domain.ports.out.UserRepositoryPortOut;
import br.com.postech.auth.domain.ports.out.UserTenantRepositoryPortOut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

@Service
public class ValidUserUseCase implements ValidUserPortIn {

    private final UserRepositoryPortOut userRepository;
    private final UserTenantRepositoryPortOut userTenantRepository;
    private final JwtEncoder jwtEncoder;
    private final String issuer;
    private final long ttlSeconds;

    public ValidUserUseCase(UserRepositoryPortOut userRepositoryPortOut,
                            UserTenantRepositoryPortOut userTenantRepository,
                            JwtEncoder jwtEncoder,
                            @Value("${app.security.issuer}") String issuer,
                            @Value("${app.security.access-token.ttl-seconds}") long ttlSeconds){
        this.userRepository = userRepositoryPortOut;
        this.userTenantRepository = userTenantRepository;
        this.jwtEncoder = jwtEncoder;
        this.issuer = issuer;
        this.ttlSeconds = ttlSeconds;
    }

    @Override
    public TokenResponse generateToken(RequestLoginDto requestLoginDto){
        var user = userRepository.findByUsername(requestLoginDto.getUsername());

        if(user.isEmpty() || !user.get().getPassword().equals(requestLoginDto.getPassword())){
            throw new LoginSenhaInvalidoException();
        }

        var userTenantRoles = userTenantRepository.findByUsuarioId(user.get().getId());

        var now = Instant.now();

        List<String> roles = Collections.singletonList(userTenantRoles.isPresent() && !userTenantRoles.get().getRole().isBlank() ?
                userTenantRoles.get().getRole() : "");

        var claims = JwtClaimsSet.builder()
                .issuer(issuer)
                .issuedAt(now)
                .expiresAt(now.plusSeconds(ttlSeconds))
                .claim("roles", roles)
                .claim("client_id", userTenantRoles.get().getUsuarioId())
                .claim("tenant_id", userTenantRoles.get().getTenantId())
                .build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return TokenResponse.builder()
                .accessToken(jwtValue)
                .build();
    }

}
