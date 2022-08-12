package com.maliitourist.apigestionregions.apigestionregions.servicesImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maliitourist.apigestionregions.apigestionregions.models.DomaineActivite;
import com.maliitourist.apigestionregions.apigestionregions.repository.Domaine_activiteRepository;
import com.maliitourist.apigestionregions.apigestionregions.services.Domaine_activiteService;

@Service
public class Domaine_activiteServiceImpl implements Domaine_activiteService{
    @Autowired
    Domaine_activiteRepository repos;

    @Override
    public DomaineActivite saveDomaineActivite(DomaineActivite da) {
        // TODO Auto-generated method stub
        return repos.save(da);
    }

    @Override
    public DomaineActivite updateDomaineActivite(DomaineActivite da) {
        // TODO Auto-generated method stub
        return repos.save(da);
    }

    @Override
    public void deleteDomaineActivite(DomaineActivite da) {
        // TODO Auto-generated method stub
        repos.delete(da);
    }

    @Override
    public List<DomaineActivite> getAllDomaineActivite() {
        // TODO Auto-generated method stub
        return repos.findAll();
    }
    
}
