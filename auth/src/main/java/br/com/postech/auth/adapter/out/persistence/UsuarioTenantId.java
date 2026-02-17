package br.com.postech.auth.adapter.out.persistence;

import java.io.Serializable;
import java.util.UUID;

public class UsuarioTenantId implements Serializable {

    private UUID usuarioId;
    private UUID tenantId;
}
