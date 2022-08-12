package com.maliitourist.apigestionregions.apigestionregions.servicesImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.maliitourist.apigestionregions.apigestionregions.models.Langue;
import com.maliitourist.apigestionregions.apigestionregions.repository.LangueRepository;
import com.maliitourist.apigestionregions.apigestionregions.services.LangueService;

public class LangueServiceImpl implements LangueService{
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
    
}
