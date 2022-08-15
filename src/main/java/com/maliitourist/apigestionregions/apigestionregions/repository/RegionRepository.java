package com.maliitourist.apigestionregions.apigestionregions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maliitourist.apigestionregions.apigestionregions.models.Region;

public interface RegionRepository extends JpaRepository<Region, Integer> {
    Region findByNom(String nom);

    Region findByCode(String code);

    // liste des regions sans pays
    @Query(value = "SELECT code, nom, superficie, domaine_activite, langue FROM Region", nativeQuery = true)
    List<Object> RegionsSansPays();
}
