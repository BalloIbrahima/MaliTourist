package com.maliitourist.apigestionregions.apigestionregions.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Region {

    // Déclaration des variables
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int code_region;

    private String nom;

    private int superficie;

    @ManyToOne
    @JoinColumn(name = "pays")
    private Pays pays;

    @ManyToOne
    @JoinColumn(name = "population")
    private Population population;

    @ManyToOne
    @JoinColumn(name = "domaineActivite")
    private DomaineActivite domaineActivite;

    @ManyToOne
    @JoinColumn(name = "langue")
    private Langue langue;

    @ManyToOne
    @JoinColumn(name = "admin")
    private Admin admin;
    // Fin des variables

}
