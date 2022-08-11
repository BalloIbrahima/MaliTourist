package com.maliitourist.apigestionregions.apigestionregions.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Population {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int code_population;
    private int nombre_habitants;
    private String annee;

    @JsonIgnore
    @OneToMany(mappedBy = "population")
    Set<Region> region;

}
