package br.com.postech.auth.domain.ports.out;

import br.com.postech.auth.adapter.out.persistence.UsuarioTenantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserTenantRepositoryPortOut extends JpaRepository<UsuarioTenantEntity, UUID> {
    Optional<UsuarioTenantEntity> findByUsuarioId(UUID usuarioId);
}
