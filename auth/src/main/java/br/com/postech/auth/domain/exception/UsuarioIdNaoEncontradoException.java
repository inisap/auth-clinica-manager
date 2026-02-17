package br.com.postech.auth.domain.exception;

public class UsuarioIdNaoEncontradoException extends RuntimeException {

    public UsuarioIdNaoEncontradoException() {
        super ("idUser nao encontrado");
    }
}
