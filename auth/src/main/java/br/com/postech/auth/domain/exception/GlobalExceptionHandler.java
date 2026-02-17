package br.com.postech.auth.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoginSenhaInvalidoException.class)
    public ResponseEntity<String> LoginInvalido(LoginSenhaInvalidoException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    @ExceptionHandler(TenantIdNaoEncontradoException.class)
    public ResponseEntity<String> tenantNaoEncontrado(TenantIdNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(UsuarioIdNaoEncontradoException.class)
    public ResponseEntity<String> usuarioNaoEncontrado(UsuarioIdNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
