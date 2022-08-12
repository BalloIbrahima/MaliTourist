package com.maliitourist.apigestionregions.apigestionregions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maliitourist.apigestionregions.apigestionregions.models.DomaineActivite;
import com.maliitourist.apigestionregions.apigestionregions.services.Domaine_activiteService;

@RequestMapping("/domaine")
@Controller
public class Domaine_activiteController {
    
    @Autowired
    private Domaine_activiteService service;

    @PostMapping("/creer")
    public DomaineActivite creerRegion(@RequestBody DomaineActivite domaine){
        return service.saveDomaineActivite(domaine);
    }
    
}
