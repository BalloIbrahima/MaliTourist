package com.maliitourist.apigestionregions.apigestionregions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maliitourist.apigestionregions.apigestionregions.models.Population;

public interface PopulationRepository extends JpaRepository<Population, Long> {
    Population findByCode(Long code);
}
