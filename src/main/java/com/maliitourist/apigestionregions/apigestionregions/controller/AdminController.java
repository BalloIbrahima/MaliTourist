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
import com.maliitourist.apigestionregions.apigestionregions.models.Admin;
import com.maliitourist.apigestionregions.apigestionregions.servicesImplementation.AdminServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "admin", description = "Les actions de l'adlinistrateur")
@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private AdminServiceImpl service;

    // methode pour la création d'un Admin
    @ApiOperation(value = "Création d'un administrateur.")
    @PostMapping("/creer")
    public ResponseEntity<Object> CreerAdmin(@RequestBody Admin Admin) {

        Admin EnregistreAdmin = service.saveAdmin(Admin);
        return ResponseMessage.generateResponse("Admin ajouté avec succes", HttpStatus.OK, EnregistreAdmin);

    }
    // Fin

    // methode pour la mise à jour d'un Admin
    @ApiOperation(value = "Mis à jour d'un administrateur.")
    @PutMapping("/mettreajour")
    public ResponseEntity<Object> MiseAJourAdmin(@RequestBody Admin Admin) {

        Admin EnregistreAdmin = service.updateAdmin(Admin);
        return ResponseMessage.generateResponse("Admin modifié avec succes", HttpStatus.OK, EnregistreAdmin);

    }
    // Fin

    // methode pour la surpression d'un Admin
    @ApiOperation(value = "Surpression d'un administrateur.")
    @DeleteMapping("/suprimer")
    public ResponseEntity<Object> SuprimerAdmin(@RequestBody Admin Admin) {

        try {
            service.deleteAdmin(Admin);
            return ResponseMessage.generateResponse("Admin suprimer!", HttpStatus.OK, null);

        } catch (Exception e) {
            return ResponseMessage.generateResponse("Erreur lors de la surpression.", HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la liste des Admin
    @ApiOperation(value = "Récuperation de la liste des administrateurs.")
    @GetMapping("/liste")
    public ResponseEntity<Object> ListeAdmin() {

        try {
            return ResponseMessage.generateResponse("La liste des admins:", HttpStatus.OK, service.getAllAdmin());

        } catch (Exception e) {
            return ResponseMessage.generateResponse("Erreur lors du retour de la liste.", HttpStatus.OK, null);
        }

    }
    // Fin
}
