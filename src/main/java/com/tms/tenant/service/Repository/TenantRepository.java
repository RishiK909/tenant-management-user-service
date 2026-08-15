package com.tms.tenant.service.Repository;


import com.tms.tenant.service.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
    Optional<Tenant> findByUserId(UUID userId);
}
