package com.maliitourist.apigestionregions.apigestionregions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maliitourist.apigestionregions.apigestionregions.models.Langue;

public interface LangueRepository extends JpaRepository<Langue, Integer> {
    Langue findByLibele(String nom);

}
