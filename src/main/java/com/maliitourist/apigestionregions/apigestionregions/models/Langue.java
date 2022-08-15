package com.maliitourist.apigestionregions.apigestionregions.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Langue {
    @Id
    private String code;
    private String libele;

    @JsonIgnore
    @OneToMany(mappedBy = "langue")
    List<Region> region = new ArrayList<>();

}
