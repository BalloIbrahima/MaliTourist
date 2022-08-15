package com.maliitourist.apigestionregions.apigestionregions.servicesImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maliitourist.apigestionregions.apigestionregions.models.Langue;
import com.maliitourist.apigestionregions.apigestionregions.repository.LangueRepository;
import com.maliitourist.apigestionregions.apigestionregions.services.LangueService;

@Service
public class LangueServiceImpl implements LangueService {
    @Autowired
    LangueRepository repos;

    @Override
    public Langue saveLangue(Langue l) {
        // TODO Auto-generated method stub
        return repos.save(l);
    }

    @Override
    public Langue updateLangue(Langue l) {
        // TODO Auto-generated method stub
        return repos.save(l);
    }

    @Override
    public void deleteLangue(Langue l) {
        // TODO Auto-generated method stub
        repos.delete(l);

    }

    @Override
    public List<Langue> getAllLangue() {
        // TODO Auto-generated method stub
        return repos.findAll();
    }

    @Override
    public Langue findByLibele(String nom) {
        // TODO Auto-generated method stub
        return repos.findByLibele(nom);
    }

    @Override
    public Langue getLangueByCode(String code) {
        // TODO Auto-generated method stub
        return repos.findByCode(code);
    }

}
