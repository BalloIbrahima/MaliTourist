package com.maliitourist.apigestionregions.apigestionregions.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Utilisateurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String pseudo;
    private String motDePasse;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "")
    List<Role> role = new ArrayList<>();

    @OneToMany
    List<Commentaire> commentaires = new ArrayList<>();

}
