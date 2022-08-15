package com.maliitourist.apigestionregions.apigestionregions.servicesImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maliitourist.apigestionregions.apigestionregions.models.Pays;
import com.maliitourist.apigestionregions.apigestionregions.repository.PaysRepository;
import com.maliitourist.apigestionregions.apigestionregions.services.PaysService;

@Service
public class PaysServiceImpl implements PaysService {
    @Autowired
    PaysRepository repos;

    @Override
    public Pays savePays(Pays a) {
        // TODO Auto-generated method stub
        return repos.save(a);
    }

    @Override
    public Pays getPaysByNom(String nom) {
        // TODO Auto-generated method stub
        return repos.findByNom(nom);
    }

    @Override
    public Pays updatePays(Pays a) {
        // TODO Auto-generated method stub
        return repos.save(a);
    }

    @Override
    public void deletePays(Pays a) {
        // TODO Auto-generated method stub
        repos.delete(a);
    }

    @Override
    public List<Pays> getAllPays() {
        // TODO Auto-generated method stub
        return repos.findAll();
    }

    @Override
    public Pays getPaysByCode(String code) {
        // TODO Auto-generated method stub
        return repos.findByCode(code);
    }

}
