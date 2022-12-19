package com.maliitourist.apigestionregions.apigestionregions.models;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String desciption;

    private File photo;

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

    @JsonIgnore
    @OneToMany
    List<LieuTouristiques> lieuTouristiques = new ArrayList<>();

    @JsonIgnore
    @OneToMany
    List<Commentaire> commentaires = new ArrayList<>();
    //

    // @ManyToOne
    // @JoinColumn(name = "admin")
    // private Admin admin;
    // Fin des variables

}
