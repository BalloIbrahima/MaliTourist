package com.maliitourist.apigestionregions.apigestionregions.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    private int code;
    private Long nombre_habitants;
    private Long annee;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "population")
    List<Region> region = new ArrayList<>();

}
