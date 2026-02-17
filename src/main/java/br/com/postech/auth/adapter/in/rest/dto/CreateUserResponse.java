package br.com.postech.auth.adapter.in.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class CreateUserResponse {

    private UUID idUsuario;
    private String nome;
    private Boolean usuarioAtivo;

}
