package br.com.postech.auth.domain.ports.in;

import br.com.postech.auth.adapter.in.rest.dto.AssociateTenantUserRolesResponse;
import br.com.postech.auth.adapter.in.rest.dto.RequestAssociateTenantUserRolesDto;

public interface AssociateTenantUserRolesPortIn {
    public AssociateTenantUserRolesResponse create(RequestAssociateTenantUserRolesDto requestAssociateTenantUserRolesDto);
}
