package com.maliitourist.apigestionregions.apigestionregions.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.maliitourist.apigestionregions.apigestionregions.models.DomaineActivite;

@Service
public interface Domaine_activiteService {

    DomaineActivite saveDomaineActivite(DomaineActivite da);

    DomaineActivite updateDomaineActivite(DomaineActivite da);

    void deleteDomaineActivite(DomaineActivite da);

    List<DomaineActivite> getAllDomaineActivite();

    DomaineActivite FindByNom(String nom);

}
