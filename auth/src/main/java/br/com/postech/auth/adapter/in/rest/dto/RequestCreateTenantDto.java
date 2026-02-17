package br.com.postech.auth.adapter.in.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RequestCreateTenantDto {

    private String nome;
    private String tipo;

}
