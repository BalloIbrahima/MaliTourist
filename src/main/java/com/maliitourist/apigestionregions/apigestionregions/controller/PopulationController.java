package com.maliitourist.apigestionregions.apigestionregions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maliitourist.apigestionregions.apigestionregions.message.ResponseMessage;
import com.maliitourist.apigestionregions.apigestionregions.models.Population;
import com.maliitourist.apigestionregions.apigestionregions.models.Region;
import com.maliitourist.apigestionregions.apigestionregions.services.PopulationService;
import com.maliitourist.apigestionregions.apigestionregions.services.RegionService;

import io.swagger.annotations.Api;

@RequestMapping("/population")
@Api(value = "population", description = "Les actions à réaliser sur la table population(creation, modification, etc ...).")
@RestController
public class PopulationController {

    @Autowired
    PopulationService service;

    @Autowired
    RegionService Rservice;

    // methode pour la création d'un Population
    @PostMapping("/creer")
    public ResponseEntity<Object> CreerPopulation(@RequestBody Population Population) {

        Population EnregistrePopulation = service.savePopulation(Population);
        return ResponseMessage.generateResponse("Population ajoutée avec succes", HttpStatus.OK, EnregistrePopulation);

    }
    // Fin

    // methode pour la création d'une Population par rapport à une region
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

}
