package com.maliitourist.apigestionregions.apigestionregions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maliitourist.apigestionregions.apigestionregions.models.Langue;

public interface LangueRepository extends JpaRepository<Langue, Long> {
    Langue findByLibele(String nom);

    Langue findByCode(String code);

}
