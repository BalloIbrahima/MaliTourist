package com.maliitourist.apigestionregions.apigestionregions.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Region {

    // Déclaration des variables
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int code_region;

    private String nom;

    private int superficie;

    // @OneToMany
    // private Pays pays;

    // @OneToMany
    // private Population population;

    // @OneToMany
    // private DomaineActivite domaineActivite;

    // @OneToMany
    // private Langue langue;

    @ManyToOne
    private Admin admin;
    // Fin des varioables

}
