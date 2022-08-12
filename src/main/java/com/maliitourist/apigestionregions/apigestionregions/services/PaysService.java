package com.maliitourist.apigestionregions.apigestionregions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maliitourist.apigestionregions.apigestionregions.models.Pays;

@Service
public interface PaysService {
    // Methode pour la création d'un pays
    Pays savePays(Pays a);

    // Methode pour la recuperation d'un pays à travers le nom
    Pays getPaysByNom(String nom);

    // Methode pour la modification d'un Pays
    Pays updatePays(Pays a);

    // Methode pour la surpression d'un Pays à partir d'un Pays
    void deletePays(Pays a);

    // Methode pour la liste des Pays
    List<Pays> getAllPays();
}
