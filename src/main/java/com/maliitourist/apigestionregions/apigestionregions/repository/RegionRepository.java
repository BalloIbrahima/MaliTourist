package com.maliitourist.apigestionregions.apigestionregions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maliitourist.apigestionregions.apigestionregions.models.Region;

public interface RegionRepository extends JpaRepository<Region, Integer> {
    Region findByNom(String nom);

}
