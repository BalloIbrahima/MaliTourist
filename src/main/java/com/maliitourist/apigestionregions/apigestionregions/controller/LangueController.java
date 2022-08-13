package com.maliitourist.apigestionregions.apigestionregions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maliitourist.apigestionregions.apigestionregions.message.ResponseMessage;
import com.maliitourist.apigestionregions.apigestionregions.models.Langue;
import com.maliitourist.apigestionregions.apigestionregions.services.LangueService;

import io.swagger.annotations.Api;

@RequestMapping("/langue")
@Api(value = "langue", description = "Les actions à réaliser sur la table langue(creation, modification, etc ...).")
@RestController
public class LangueController {

    @Autowired
    private LangueService service;

    // methode pour la création d'une Region
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
}
