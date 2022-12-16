package com.maliitourist.apigestionregions.apigestionregions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maliitourist.apigestionregions.apigestionregions.message.ResponseMessage;
import com.maliitourist.apigestionregions.apigestionregions.models.DomaineActivite;
import com.maliitourist.apigestionregions.apigestionregions.models.Langue;
import com.maliitourist.apigestionregions.apigestionregions.models.Pays;
import com.maliitourist.apigestionregions.apigestionregions.models.Population;
import com.maliitourist.apigestionregions.apigestionregions.models.Region;
import com.maliitourist.apigestionregions.apigestionregions.services.Domaine_activiteService;
import com.maliitourist.apigestionregions.apigestionregions.services.LangueService;
import com.maliitourist.apigestionregions.apigestionregions.services.PaysService;
import com.maliitourist.apigestionregions.apigestionregions.services.PopulationService;
import com.maliitourist.apigestionregions.apigestionregions.services.RegionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/region")
@Api(value = "region", description = "Les actions à réaliser sur la table region(creation, modification, etc ...).")
@Controller
public class RegionController {

    @Autowired
    private RegionService service;

    @Autowired
    private PaysService Pservice;

    @Autowired
    private LangueService Lservice;

    @Autowired
    private Domaine_activiteService Dservice;

    @Autowired
    private PopulationService populationservice;

    // methode pour la création d'un Region
    @ApiOperation(value = "Recuperation d'une Region.")
    @GetMapping("/get/{nom}")
    public ResponseEntity<Object> RecupereRegion(@PathVariable(value = "nom") String nom) {

        Region verif_Region = service.getRegionByNom(nom);
        if (verif_Region != null) {
            return ResponseMessage.generateResponse("Region Trouvée ", HttpStatus.OK, verif_Region);
        } else {
            return ResponseMessage.generateResponse("Cette Region n'existe pas", HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la création d'une Region
    @ApiOperation(value = "Création d'une Region.")
    @PostMapping("/creer")
    public ResponseEntity<Object> CreerRegion(@RequestBody Region region) {

        Region verif_RegionName = service.getRegionByNom(region.getNom());
        Region verif_RegionCode = service.getRegionByCode(region.getCode());

        if (verif_RegionCode == null && verif_RegionName == null) {
            // verification de l'existance du pays, de la langue et du domaine
            Pays pays = Pservice.getPaysByNom(region.getPays().getNom());
            Langue langue = Lservice.findByLibele(region.getLangue().getLibele());
            DomaineActivite domaine = Dservice.FindByNom(region.getDomaineActivite().getNom());
            //
            // s'il l'une d'entre elles n'existe pas la créer
            if (pays == null) {
                Pservice.savePays(region.getPays());
            }
            if (langue == null) {
                Lservice.saveLangue(region.getLangue());
            }
            if (domaine == null) {
                Dservice.saveDomaineActivite(region.getDomaineActivite());
            }

            for (int i = 0; i < region.getPopulation().size(); i++) {
                Population p = populationservice.FindByCode(region.getPopulation().get(i).getCode());
                if (p == null) {
                    // recuperation du domaine qui se trouve dans la population et on lui ajoute la
                    // population courante dans sa liste de population
                    // on enregistre d'abord la population
                    populationservice.savePopulation(region.getPopulation().get(i));
                    // region.getPopulation().get(i).getRegion().add(region);

                }
            }
            //
            // après créer la region
            Region EnregistreRegion = service.saveRegion(region);
            return ResponseMessage.generateResponse("Region ajoutée avec succes", HttpStatus.OK, EnregistreRegion);
        } else {
            return ResponseMessage.generateResponse("Cette Region existe déja", HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la mise à jour d'une Region
    @ApiOperation(value = "Mis à jour d'une Region.")
    @PutMapping("/mettreajour/{CodeRegion}")
    public ResponseEntity<Object> MiseAJourRegion(@RequestBody Region region,
            @PathVariable(value = "CodeRegion") String code) {

        System.out.println(region.getNom());
        Region verif_Region = service.getRegionByCode(code);
        if (verif_Region == null) {
            Region EnregistreRegion = service.updateRegion(region);
            return ResponseMessage.generateResponse("Region modifiée avec succes", HttpStatus.OK, EnregistreRegion);
        } else {
            return ResponseMessage.generateResponse("Cette Region n'existe pas, donc vous ne pouvez pas la modifiée.",
                    HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la surpression d'une Region
    @ApiOperation(value = "Supression d'une Region.")
    @DeleteMapping("/{codeRegion}")
    public ResponseEntity<Object> SuprimerRegion(@PathVariable(value = "codeRegion") String code) {

        Region Region = service.getRegionByCode(code);

        try {
            service.deleteRegion(Region);
            return ResponseMessage.generateResponse("Region suprimée!", HttpStatus.OK, null);

        } catch (Exception e) {
            return ResponseMessage.generateResponse("Erreur lors de la surpression.", HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la liste des Region
    @ApiOperation(value = "Recuperation de la liste des Regions avec pays.")
    @GetMapping("/get/liste")
    public ResponseEntity<Object> ListeRegion() {

        try {
            return ResponseMessage.generateResponse("La liste de Region:", HttpStatus.OK, service.getAllRegion());

        } catch (Exception e) {
            return ResponseMessage.generateResponse("Erreur lors du retour de la liste.", HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la liste des Region
    @ApiOperation(value = "Recuperation de la liste des Regions sans pays.")
    @GetMapping("/get/listeSansPays")
    public ResponseEntity<Object> ListeRegionSans() {

        try {
            return ResponseMessage.generateResponse("La liste de Region:", HttpStatus.OK, service.getRegionSansPay());

        } catch (Exception e) {
            return ResponseMessage.generateResponse("Erreur lors du retour de la liste.", HttpStatus.OK, null);
        }

    }
    // Fin
}
