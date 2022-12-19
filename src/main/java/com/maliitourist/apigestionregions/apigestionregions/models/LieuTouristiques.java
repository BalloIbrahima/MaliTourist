package com.maliitourist.apigestionregions.apigestionregions.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.File;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class LieuTouristiques {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private File photo;
}
