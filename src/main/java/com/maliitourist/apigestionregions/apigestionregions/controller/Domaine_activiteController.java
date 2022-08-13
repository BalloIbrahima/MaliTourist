package com.maliitourist.apigestionregions.apigestionregions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maliitourist.apigestionregions.apigestionregions.message.ResponseMessage;
import com.maliitourist.apigestionregions.apigestionregions.models.DomaineActivite;
import com.maliitourist.apigestionregions.apigestionregions.services.Domaine_activiteService;

@RequestMapping("/domaine")
@Controller
public class Domaine_activiteController {

    @Autowired
    private Domaine_activiteService service;

    // methode pour la création d'un Region
    @PostMapping("/creer")
    public ResponseEntity<Object> creerRegion(@RequestBody DomaineActivite domaine) {

        DomaineActivite verif_Domaine = service.FindByNom(domaine.getNom());
        if (verif_Domaine == null) {
            DomaineActivite EnregistreDomaine = service.saveDomaineActivite(domaine);
            return ResponseMessage.generateResponse("Domaine ajoutée avec succes", HttpStatus.OK, EnregistreDomaine);
        } else {
            return ResponseMessage.generateResponse("Cet domaine existe déja", HttpStatus.OK, verif_Domaine);
        }

    }
    // Fin

}
