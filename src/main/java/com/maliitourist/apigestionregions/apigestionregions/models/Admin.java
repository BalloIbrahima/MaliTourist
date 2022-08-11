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


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Admin {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_admin;
    private String nom;
    private String prenom;

    @JsonIgnore
    @OneToMany(mappedBy = "admin")
    Set<Region> region;

}
