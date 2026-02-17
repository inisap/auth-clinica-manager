package br.com.postech.auth.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Entity
@Builder
@Table(name = "usuario_tenant")
@NoArgsConstructor
@AllArgsConstructor
@IdClass(UsuarioTenantId.class)
public class UsuarioTenantEntity {

    @Id
    @Column(name = "usuario_id")
    private UUID usuarioId;

    @Id
    @Column(name = "tenant_id")
    private UUID tenantId;

    @Column(length = 200)
    private String role;

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UUID usuarioId) {
        this.usuarioId = usuarioId;
    }

    public UUID getTenantId() {
        return tenantId;
    }

    public void setTenantId(UUID tenantId) {
        this.tenantId = tenantId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}