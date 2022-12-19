package com.maliitourist.apigestionregions.apigestionregions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maliitourist.apigestionregions.apigestionregions.models.Region;

@Service
public interface RegionService {

    // methode pour la recuperation d'une region à travers son Id
    Region getRegionByCode(String code);

    // Methode pour la recuperation d'une region
    Region getRegion(Region an);
    //ajouter une region à partir d'un pays
    Object postRegion(Region region, String codePays);

    // Methode pour la création d'une region
    Region saveRegion(Region a);

    // Methode pour la modification d'un Region
    Region updateRegion(Region a);

    // Methode pour la recuperation d'un pays à travers le nom
    Region getRegionByNom(String nom);

    // Methode pour la surpression d'un Region à partir d'un Region
    void deleteRegion(Region a);

    // Methode pour la liste des Regions
    List<Region> getAllRegion();

    // Methode pour la liste des Regions sans pays
    List<Object> getRegionSansPay();
}
