package br.com.postech.auth.domain.exception;

public class TenantIdNaoEncontradoException extends RuntimeException {

    public TenantIdNaoEncontradoException() {
        super ("idTenant nao encontrado");
    }
}
