package com.maliitourist.apigestionregions.apigestionregions.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maliitourist.apigestionregions.apigestionregions.models.ERole;
import com.maliitourist.apigestionregions.apigestionregions.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
