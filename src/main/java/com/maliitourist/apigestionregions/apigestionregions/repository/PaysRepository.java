package com.maliitourist.apigestionregions.apigestionregions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maliitourist.apigestionregions.apigestionregions.models.Pays;

public interface PaysRepository extends JpaRepository<Pays, Long> {
    Pays findByNom(String nom);

    Pays findByCode(String code);

}
