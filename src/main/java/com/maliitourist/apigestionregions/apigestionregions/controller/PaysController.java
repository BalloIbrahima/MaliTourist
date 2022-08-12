package com.maliitourist.apigestionregions.apigestionregions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    // methode pour la création d'un pays
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
    // Fin

    // methode pour la mise à jour d'un pays
    @PutMapping("/mettreajour")
    public ResponseEntity<Object> MiseAJourPays(@RequestBody Pays pays) {

        System.out.println(pays);
        Pays verif_pays = service.getPaysByNom(pays.getNom());
        if (verif_pays != null) {
            Pays Enregistrepays = service.updatePays(pays);
            return ResponseMessage.generateResponse("Pays modifié avec succes", HttpStatus.OK, Enregistrepays);
        } else {
            return ResponseMessage.generateResponse("Ce pays n'existe pas, donc vous ne pouvez pas le modifié.",
                    HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la surpression d'un pays
    @DeleteMapping("/suprimer")
    public ResponseEntity<Object> SuprimerPays(@RequestBody Pays pays) {

        try {
            service.deletePays(pays);
            return ResponseMessage.generateResponse("Ce pays existe déja", HttpStatus.OK, null);

        } catch (Exception e) {
            return ResponseMessage.generateResponse("Erreur lors de la surpression.", HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la liste des pays
    @GetMapping("/liste")
    public ResponseEntity<Object> ListePays() {

        try {
            return ResponseMessage.generateResponse("La liste de pays:", HttpStatus.OK, service.getAllPays());

        } catch (Exception e) {
            return ResponseMessage.generateResponse("Erreur lors du retour de la liste.", HttpStatus.OK, null);
        }

    }
    // Fin
}
