package br.com.postech.auth.application.usecases;

import br.com.postech.auth.adapter.in.rest.dto.CreateTenantResponse;
import br.com.postech.auth.adapter.in.rest.dto.CreateUserResponse;
import br.com.postech.auth.adapter.in.rest.dto.RequestCreateTenantDto;
import br.com.postech.auth.adapter.in.rest.dto.RequestCreateUserDto;
import br.com.postech.auth.adapter.in.rest.mapper.TenantMapper;
import br.com.postech.auth.adapter.in.rest.mapper.UserMapper;
import br.com.postech.auth.domain.ports.in.CreateTenantPortIn;
import br.com.postech.auth.domain.ports.in.CreateUserPortIn;
import br.com.postech.auth.domain.ports.out.TenantRepositoryPortOut;
import br.com.postech.auth.domain.ports.out.UserRepositoryPortOut;
import org.springframework.stereotype.Service;

@Service
public class CreateTenantUseCase implements CreateTenantPortIn {

    private final TenantRepositoryPortOut tenantRepositoryPortOut;

    public CreateTenantUseCase(TenantRepositoryPortOut tenantRepositoryPortOut){
        this.tenantRepositoryPortOut = tenantRepositoryPortOut;

    }

    @Override
    public CreateTenantResponse create(RequestCreateTenantDto requestCreateTenantDto){

        var entity = TenantMapper.createTenantDtoToEntity(requestCreateTenantDto);

        var savedEntity = tenantRepositoryPortOut.save(entity);

        return TenantMapper.entityUserToCreateTenantResponse(savedEntity);
    }
}
