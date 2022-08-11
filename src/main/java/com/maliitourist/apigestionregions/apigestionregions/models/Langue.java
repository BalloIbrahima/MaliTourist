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
public class Langue {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int code_langue;
    private String libele;

    @JsonIgnore
    @OneToMany(mappedBy = "langue")
    Set <Region> region;


}
