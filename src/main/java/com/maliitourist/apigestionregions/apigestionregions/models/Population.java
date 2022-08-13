package com.maliitourist.apigestionregions.apigestionregions.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Population {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int code_population;
    private Long nombre_habitants;
    private Long annee;

    @JsonIgnore
    @ManyToMany(mappedBy = "population")
    Set<Region> region;

}
