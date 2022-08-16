package com.maliitourist.apigestionregions.apigestionregions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maliitourist.apigestionregions.apigestionregions.message.ResponseMessage;
import com.maliitourist.apigestionregions.apigestionregions.models.Langue;
import com.maliitourist.apigestionregions.apigestionregions.services.LangueService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/langue")
@Api(value = "langue", description = "Les actions à réaliser sur la table langue(creation, modification, etc ...).")
@RestController
public class LangueController {

    @Autowired
    private LangueService service;

    // methode pour la création d'une Langue
    @ApiOperation(value = "Creation d'une langue.")
    @PostMapping("/creer")
    public ResponseEntity<Object> creerLangue(@RequestBody Langue Langue) {

        Langue verif_Langue = service.findByLibele(Langue.getLibele());
        if (verif_Langue == null) {
            Langue EnregistreLangue = service.saveLangue(Langue);
            return ResponseMessage.generateResponse("Langue ajoutée avec succes", HttpStatus.OK, EnregistreLangue);
        } else {
            return ResponseMessage.generateResponse("Cette Langue existe déja", HttpStatus.OK, verif_Langue);
        }

    }
    // Fin

    // methode pour la mise à jour d'un langue
    @ApiOperation(value = "Mis à jour d'une langue.")
    @PutMapping("/misajour/{codeRegion}")
    public ResponseEntity<Object> ModifierRegion(@RequestBody Langue langue,
            @PathVariable(value = "CodeRegion") String code) {

        Langue verif_Langue = service.getLangueByCode(code);
        if (verif_Langue != null) {
            Langue EnregistreLangue = service.updateLangue(langue);
            return ResponseMessage.generateResponse("Langue Modifiée avec succes", HttpStatus.OK, EnregistreLangue);
        } else {
            return ResponseMessage.generateResponse("Cette langue n'existe pas!", HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la recuperation d'une langue à travers son codedomaine
    @ApiOperation(value = "Recuperation d'une langue à travers son le codeLangue.")
    @GetMapping("/{codeLangue}")
    public ResponseEntity<Object> RecupereLangue(
            @PathVariable(value = "CodeRegion") String code) {

        Langue verif_Langue = service.getLangueByCode(code);
        if (verif_Langue != null) {
            return ResponseMessage.generateResponse("", HttpStatus.OK, verif_Langue);
        } else {
            return ResponseMessage.generateResponse("Cett Langue n'existe pas:", HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la surpression des domaines
    @ApiOperation(value = "Modification d'une langue.")
    @DeleteMapping("/{codeLangue}")
    public ResponseEntity<Object> SuprimerLangue(
            @PathVariable(value = "CodeLangue") String code) {

        Langue verif_Langue = service.getLangueByCode(code);
        if (verif_Langue != null) {
            service.deleteLangue(verif_Langue);
            return ResponseMessage.generateResponse("Langue Suprime !", HttpStatus.OK, null);
        } else {
            return ResponseMessage.generateResponse("Cette Langue n'existe pas:", HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la recupération des domaines
    @ApiOperation(value = "Supression d'une langue.")
    @GetMapping("/liste")
    public ResponseEntity<Object> LesLangues() {

        try {
            return ResponseMessage.generateResponse("Liste des langues", HttpStatus.OK,
                    service.getAllLangue());
        } catch (Exception e) {
            return ResponseMessage.generateResponse("Erreur ", HttpStatus.OK, e.getMessage());
        }

    }
    // Fin

}
