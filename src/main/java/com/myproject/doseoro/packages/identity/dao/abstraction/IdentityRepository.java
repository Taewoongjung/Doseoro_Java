package com.myproject.doseoro.packages.identity.dao.abstraction;

import com.myproject.doseoro.packages.identity.domain.Identity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IdentityRepository extends JpaRepository<Identity, Long> {
    Identity findById(UUID id);

    boolean existsByEmail(String email);
}
