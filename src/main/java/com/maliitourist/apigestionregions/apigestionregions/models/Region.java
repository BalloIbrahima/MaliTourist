package com.maliitourist.apigestionregions.apigestionregions.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

public class Region {

    // Déclaration des variables
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int code_region;

    private String nom;

    private int superficie;

    @OneToMany
    private Pays pays;

    @OneToMany
    private Population population;

    @OneToMany
    private DomaineActivite domaineActivite;

    @OneToMany
    private Langue langue;

    @OneToMany
    private Admin admin;
    // Fin des varioables

    // Constructeur
    public Region(Pays pays, int code_region, String nom, DomaineActivite domaine, int superficie,
            Population population, Admin admin) {

        this.pays = pays;
        this.code_region = code_region;
        this.nom = nom;
        this.domaineActivite = domaine;
        this.superficie = superficie;
        this.population = population;
        this.admin = admin;
    }
    //

    // Getters et setters

}
