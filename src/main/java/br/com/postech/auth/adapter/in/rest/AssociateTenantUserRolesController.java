package br.com.postech.auth.adapter.in.rest;

import br.com.postech.auth.adapter.in.rest.dto.AssociateTenantUserRolesResponse;
import br.com.postech.auth.adapter.in.rest.dto.RequestAssociateTenantUserRolesDto;
import br.com.postech.auth.application.usecases.AssociateTenantUserRolesUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/associate-roles")
public class AssociateTenantUserRolesController {

    private final AssociateTenantUserRolesUseCase associateTenantUserRolesUseCase;

    public AssociateTenantUserRolesController(AssociateTenantUserRolesUseCase associateTenantUserRolesUseCase){
        this.associateTenantUserRolesUseCase = associateTenantUserRolesUseCase;
    }

    @PreAuthorize("hasAuthority('ADM')")
    @PutMapping()
    public ResponseEntity<AssociateTenantUserRolesResponse> associarTenantUser(
            @RequestBody RequestAssociateTenantUserRolesDto requestAssociateTenantUserRolesDto
    ) {
        var tenantUSerRolesResponse = associateTenantUserRolesUseCase.create(requestAssociateTenantUserRolesDto);

        return ResponseEntity.ok().body(tenantUSerRolesResponse);
    }

}
