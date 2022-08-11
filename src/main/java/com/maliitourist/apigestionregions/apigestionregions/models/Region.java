package com.maliitourist.apigestionregions.apigestionregions.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
<<<<<<< HEAD
=======

>>>>>>> 4d56b3fb2e12132c04fa5a50e428fdfcf15f8d29

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
<<<<<<< HEAD
import lombok.Setter;
=======
>>>>>>> 4d56b3fb2e12132c04fa5a50e428fdfcf15f8d29

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
