package br.com.postech.auth.domain.ports.out;

import br.com.postech.auth.adapter.out.persistence.TenantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TenantRepositoryPortOut extends JpaRepository<TenantEntity, UUID> {
//    Optional<TenantEntity> findByTenantId(UUID tenantId);
}
