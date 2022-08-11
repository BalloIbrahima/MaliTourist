package com.maliitourist.apigestionregions.apigestionregions.services;

import java.util.List;

import com.maliitourist.apigestionregions.apigestionregions.models.Region;

public interface RegionService {
    // Methode pour la création d'un admin
    Region saveRegion(Region a);

    // Methode pour la modification d'un Region
    Region updateRegion(Region a);

    // Methode pour la surpression d'un Region à partir d'un Region
    void deleteRegion(Region a);

    // Methode pour la liste des Regions à partir d'un Region
    List<Region> getAllRegion();
}
