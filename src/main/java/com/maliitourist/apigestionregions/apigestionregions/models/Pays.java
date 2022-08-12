package com.maliitourist.apigestionregions.apigestionregions.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Pays {

    @Id
    private String code_pays;
    private String nom;

    @JsonIgnore
    @OneToMany(mappedBy = "pays")
    Set<Region> region;

}
