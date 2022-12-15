package com.maliitourist.apigestionregions.apigestionregions.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maliitourist.apigestionregions.apigestionregions.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByUsername(String username);

}
