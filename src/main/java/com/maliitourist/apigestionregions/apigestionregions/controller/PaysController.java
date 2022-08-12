package com.maliitourist.apigestionregions.apigestionregions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maliitourist.apigestionregions.apigestionregions.message.ResponseMessage;
import com.maliitourist.apigestionregions.apigestionregions.models.Pays;
import com.maliitourist.apigestionregions.apigestionregions.servicesImplementation.PaysServiceImpl;

@RequestMapping("/pays")
@Controller
public class PaysController {

    @Autowired
    private PaysServiceImpl service;

    @PostMapping("/creer")
    public ResponseEntity<Object> CreerPays(@RequestBody Pays pays) {

        System.out.println(pays);
        Pays verif_pays = service.getPaysByNom(pays.getNom());
        if (verif_pays == null) {
            Pays Enregistrepays = service.savePays(pays);
            return ResponseMessage.generateResponse("Pays ajouté avec succes", HttpStatus.OK, Enregistrepays);
        } else {
            return ResponseMessage.generateResponse("Ce pays existe déja", HttpStatus.OK, verif_pays);
        }

    }
}
