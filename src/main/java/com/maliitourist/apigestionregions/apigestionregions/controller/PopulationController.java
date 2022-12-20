package com.maliitourist.apigestionregions.apigestionregions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maliitourist.apigestionregions.apigestionregions.message.response.ResponseMessage;
import com.maliitourist.apigestionregions.apigestionregions.models.Population;
import com.maliitourist.apigestionregions.apigestionregions.models.Region;
import com.maliitourist.apigestionregions.apigestionregions.services.PopulationService;
import com.maliitourist.apigestionregions.apigestionregions.services.RegionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/population")
@Api(value = "population", description = "Les actions à réaliser sur la table population(creation, modification, etc ...).")
@RestController
public class PopulationController {

    @Autowired
    PopulationService service;

    @Autowired
    RegionService Rservice;

    // methode pour la création d'un Population
    @ApiOperation(value = "Création d'une population.")
    @PostMapping("/creer")
    public ResponseEntity<Object> CreerPopulation(@RequestBody Population Population) {

        Population EnregistrePopulation = service.savePopulation(Population);
        return ResponseMessage.generateResponse("Population ajoutée avec succes", HttpStatus.OK, EnregistrePopulation);

    }
    // Fin

    // methode pour la création d'une Population par rapport à une region
    @ApiOperation(value = "Création d'une population à travers le code d'une region(On l'ajoute à la region).")
    @PostMapping("/{CodeRegion}/creer")
    public ResponseEntity<Object> CreerPopulationRegion(@PathVariable(value = "CodeRegion") String code,
            @RequestBody Population population) {
        Region region = Rservice.getRegionByCode(code);
        System.out.println(region);

        if (region != null) {
            population.getRegion().add(region);
            region.getPopulation().add(population);
            service.updatePopulation(population);
            Rservice.updateRegion(region);
            return ResponseMessage.generateResponse("Population ajoutée avec succes", HttpStatus.OK, region);

        } else {
            return ResponseMessage.generateResponse("Cette region n'existe pas!", HttpStatus.OK, null);

        }

    }
    // Fin

    // methode pour la mise à jour d'une populaton
    @ApiOperation(value = "Modificatio d'une population.")
    @PutMapping("/misajour/{codePopulation}")
    public ResponseEntity<Object> ModifierRegion(@RequestBody Population population,
            @PathVariable(value = "codePopulation") Long code) {

        Population verif_Langue = service.FindByCode(code);
        if (verif_Langue != null) {
            Population EnregistreLangue = service.updatePopulation(population);
            return ResponseMessage.generateResponse("Langue Modifiée avec succes", HttpStatus.OK, EnregistreLangue);
        } else {
            return ResponseMessage.generateResponse("Cette langue n'existe pas!", HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la recuperation d'une population à travers son codedomaine
    @ApiOperation(value = "Recuperation d'une population.")
    @GetMapping("/{codePopulation}")
    public ResponseEntity<Object> RecupereLangue(
            @PathVariable(value = "CodeRegion") Long code) {

        Population verif_Langue = service.FindByCode(code);
        if (verif_Langue != null) {
            return ResponseMessage.generateResponse("", HttpStatus.OK, verif_Langue);
        } else {
            return ResponseMessage.generateResponse("Cett population n'existe pas:", HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la surpression des domaines
    @ApiOperation(value = "Su^pression d'une population.")
    @DeleteMapping("/{codePopulation}")
    public ResponseEntity<Object> SuprimerLangue(
            @PathVariable(value = "CodePopulation") Long code) {

        Population verif_Population = service.FindByCode(code);
        if (verif_Population != null) {
            service.deletePopulation(verif_Population);
            return ResponseMessage.generateResponse("Population Suprime !", HttpStatus.OK, null);
        } else {
            return ResponseMessage.generateResponse("Cette Population n'existe pas:", HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la recupération des domaines
    @GetMapping("/liste")
    public ResponseEntity<Object> LesPopulations() {

        try {
            return ResponseMessage.generateResponse("Liste des populations", HttpStatus.OK,
                    service.getAllPopulation());
        } catch (Exception e) {
            return ResponseMessage.generateResponse("Erreur ", HttpStatus.OK, e.getMessage());
        }

    }
    // Fin

}
