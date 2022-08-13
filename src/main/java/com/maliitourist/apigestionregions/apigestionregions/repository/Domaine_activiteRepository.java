package com.maliitourist.apigestionregions.apigestionregions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maliitourist.apigestionregions.apigestionregions.models.DomaineActivite;

public interface Domaine_activiteRepository extends JpaRepository<DomaineActivite, Integer> {
    DomaineActivite findByNom(String nom);

}
