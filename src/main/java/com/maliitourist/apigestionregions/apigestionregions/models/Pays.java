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
public class Pays {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int code_pays;
    private String nom;

    @JsonIgnore
    @OneToMany(mappedBy = "pays")
    Set<Region> region;

}
