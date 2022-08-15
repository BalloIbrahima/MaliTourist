package com.maliitourist.apigestionregions.apigestionregions.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    private String code;

    private String nom;

    private int superficie;

    @ManyToOne
    @JoinColumn(name = "pays")
    private Pays pays;

    @ManyToMany
    @JoinTable(name = "PopulationRegion", joinColumns = { @JoinColumn(name = "idRegion") }, inverseJoinColumns = {
            @JoinColumn(name = "idPopulation") })
    List<Population> population = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "domaineActivite")
    private DomaineActivite domaineActivite;

    @ManyToOne
    @JoinColumn(name = "langue")
    private Langue langue;
    //

    @ManyToOne
    @JoinColumn(name = "admin")
    private Admin admin;
    // Fin des variables

}
