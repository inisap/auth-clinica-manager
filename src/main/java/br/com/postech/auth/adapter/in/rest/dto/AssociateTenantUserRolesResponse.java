package br.com.postech.auth.adapter.in.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class AssociateTenantUserRolesResponse {

    private UUID idTenant;

    private UUID idUser;

    private String roles;

}
