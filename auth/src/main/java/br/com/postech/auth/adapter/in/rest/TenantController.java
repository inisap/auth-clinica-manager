package br.com.postech.auth.adapter.in.rest;

import br.com.postech.auth.adapter.in.rest.dto.*;
import br.com.postech.auth.application.usecases.CreateTenantUseCase;
import br.com.postech.auth.application.usecases.CreateUserUseCase;
import br.com.postech.auth.application.usecases.ValidUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tenants")
public class TenantController {

    private final CreateTenantUseCase createTenantUseCase;

    public TenantController(CreateTenantUseCase createTenantUseCase){
        this.createTenantUseCase = createTenantUseCase;
    }

    @PreAuthorize("hasAuthority('ADM')")
    @PostMapping()
    public ResponseEntity<CreateTenantResponse> createNewTenant(
            @RequestBody RequestCreateTenantDto requestCreateTenantDto
    ) {
        var tenantResponse = createTenantUseCase.create(requestCreateTenantDto);

        return ResponseEntity.ok().body(tenantResponse);
    }

}
