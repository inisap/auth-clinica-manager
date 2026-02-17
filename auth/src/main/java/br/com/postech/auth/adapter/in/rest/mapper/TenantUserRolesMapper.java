package br.com.postech.auth.adapter.in.rest.mapper;

import br.com.postech.auth.adapter.in.rest.dto.AssociateTenantUserRolesResponse;
import br.com.postech.auth.adapter.in.rest.dto.RequestAssociateTenantUserRolesDto;
import br.com.postech.auth.adapter.out.persistence.UsuarioTenantEntity;

public class TenantUserRolesMapper {

    public static UsuarioTenantEntity associateTenantUserRolesDtoToEntity(RequestAssociateTenantUserRolesDto requestAssociateTenantUserRoles){

        return UsuarioTenantEntity.builder()
                .usuarioId(requestAssociateTenantUserRoles.getIdUser())
                .tenantId(requestAssociateTenantUserRoles.getIdTenant())
                .role(requestAssociateTenantUserRoles.getRoles())
                .build();
    }

    public static AssociateTenantUserRolesResponse entityTenantUserToAssociateTenantUserRolesResponse(UsuarioTenantEntity entity){
        return AssociateTenantUserRolesResponse.builder()
                .idTenant(entity.getTenantId())
                .idUser(entity.getUsuarioId())
                .roles(entity.getRole())
                .build();
    }
}
