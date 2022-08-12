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
import com.maliitourist.apigestionregions.apigestionregions.models.Region;
import com.maliitourist.apigestionregions.apigestionregions.servicesImplementation.RegionServiceImpl;

@RequestMapping("/region")
@Controller
public class RegionController {

    @Autowired
    private RegionServiceImpl service;

    // methode pour la création d'un Region
    @GetMapping("{nom}")
    public ResponseEntity<Object> RecupereRegion(@RequestBody String nom) {

        Region verif_Region = service.getRegionByNom(nom);
        if (verif_Region != null) {
            return ResponseMessage.generateResponse("Region Trouvée ", HttpStatus.OK, verif_Region);
        } else {
            return ResponseMessage.generateResponse("Cette Region n'existe pas", HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la création d'un Region
    @PostMapping("/creer")
    public ResponseEntity<Object> CreerRegion(@RequestBody Region Region) {

        System.out.println(Region);
        Region verif_Region = service.getRegionByNom(Region.getNom());
        if (verif_Region == null) {
            Region EnregistreRegion = service.saveRegion(Region);
            return ResponseMessage.generateResponse("Region ajoutée avec succes", HttpStatus.OK, EnregistreRegion);
        } else {
            return ResponseMessage.generateResponse("Cette Region existe déja", HttpStatus.OK, verif_Region);
        }

    }
    // Fin

    // methode pour la mise à jour d'un Region
    @PutMapping("/mettreajour")
    public ResponseEntity<Object> MiseAJourRegion(@RequestBody Region Region) {

        System.out.println(Region);
        Region verif_Region = service.getRegionByNom(Region.getNom());
        if (verif_Region != null) {
            Region EnregistreRegion = service.updateRegion(Region);
            return ResponseMessage.generateResponse("Region modifiée avec succes", HttpStatus.OK, EnregistreRegion);
        } else {
            return ResponseMessage.generateResponse("Cette Region n'existe pas, donc vous ne pouvez pas la modifiée.",
                    HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la surpression d'un Region
    @DeleteMapping("/suprimer")
    public ResponseEntity<Object> SuprimerRegion(@RequestBody Region Region) {

        try {
            service.deleteRegion(Region);
            return ResponseMessage.generateResponse("Ce Region existe déja", HttpStatus.OK, null);

        } catch (Exception e) {
            return ResponseMessage.generateResponse("Erreur lors de la surpression.", HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la liste des Region
    @GetMapping("/liste")
    public ResponseEntity<Object> ListeRegion() {

        try {
            return ResponseMessage.generateResponse("La liste de Region:", HttpStatus.OK, service.getAllRegion());

        } catch (Exception e) {
            return ResponseMessage.generateResponse("Erreur lors du retour de la liste.", HttpStatus.OK, null);
        }

    }
    // Fin
}
