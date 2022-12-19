package com.maliitourist.apigestionregions.apigestionregions.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String code;
    // @Column(unique = true)
    private String nom;

    @JsonIgnore
    @OneToMany(mappedBy = "pays")
    List<Region> region = new ArrayList<>();

}
