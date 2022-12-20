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
import com.maliitourist.apigestionregions.apigestionregions.models.DomaineActivite;
import com.maliitourist.apigestionregions.apigestionregions.services.Domaine_activiteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/domaine")
@Api(value = "domaine", description = "Les actions à réaliser sur le domaine.")
@RestController
public class Domaine_activiteController {

    @Autowired
    private Domaine_activiteService service;

    // methode pour la création d'un domaine
    @ApiOperation(value = "Création d'un Domaine.")
    @PostMapping("/creer")
    public ResponseEntity<Object> creerDomaine(@RequestBody DomaineActivite domaine) {

        DomaineActivite verif_Domaine = service.FindByNom(domaine.getNom());
        if (verif_Domaine == null) {
            DomaineActivite EnregistreDomaine = service.saveDomaineActivite(domaine);
            return ResponseMessage.generateResponse("Domaine ajoutée avec succes", HttpStatus.OK, EnregistreDomaine);
        } else {
            return ResponseMessage.generateResponse("Cet domaine existe déja", HttpStatus.OK, verif_Domaine);
        }

    }
    // Fin

    // methode pour la mise à jour d'un domaine
    @ApiOperation(value = "Mise à jour d'un domaine.")
    @PutMapping("/misajour/{CodeDomaine}")
    public ResponseEntity<Object> ModifierDomaine(@RequestBody DomaineActivite domaine,
            @PathVariable(value = "CodeDomaine") String code) {

        DomaineActivite verif_Domaine = service.getDomaineByCode(code);
        if (verif_Domaine != null) {
            DomaineActivite EnregistreDomaine = service.updateDomaineActivite(domaine);
            return ResponseMessage.generateResponse("Domaine Modifié avec succes", HttpStatus.OK, EnregistreDomaine);
        } else {
            return ResponseMessage.generateResponse("Cet domaine n'existe pas!", HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la recuperation d'un domaine à travers son codedomaine
    @ApiOperation(value = "Récuperation d'un domaine.")
    @GetMapping("/{codeDomaine}")
    public ResponseEntity<Object> RecupereDomaine(
            @PathVariable(value = "CodeDomaine") String code) {

        DomaineActivite verif_Domaine = service.getDomaineByCode(code);
        if (verif_Domaine != null) {
            return ResponseMessage.generateResponse("", HttpStatus.OK, verif_Domaine);
        } else {
            return ResponseMessage.generateResponse("Cet domaine n'existe pas:", HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la surpression des domaines
    @ApiOperation(value = "Supression d'un domaine.")
    @DeleteMapping("/{codeDomaine}")
    public ResponseEntity<Object> SuprimerDomaine(
            @PathVariable(value = "CodeDomaine") String code) {

        DomaineActivite verif_Domaine = service.getDomaineByCode(code);
        if (verif_Domaine != null) {
            service.deleteDomaineActivite(verif_Domaine);
            return ResponseMessage.generateResponse("Domaine Suprime !", HttpStatus.OK, null);
        } else {
            return ResponseMessage.generateResponse("Cet domaine n'existe pas:", HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la recupération des domaines
    @ApiOperation(value = "Récuperation de la liste des domaines.")
    @GetMapping("/liste")
    public ResponseEntity<Object> LesDomaines() {

        try {
            return ResponseMessage.generateResponse("Liste des domaines", HttpStatus.OK,
                    service.getAllDomaineActivite());
        } catch (Exception e) {
            return ResponseMessage.generateResponse("Erreur ", HttpStatus.OK, e.getMessage());
        }

    }
    // Fin

}
