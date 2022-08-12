package com.maliitourist.apigestionregions.apigestionregions.servicesImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.maliitourist.apigestionregions.apigestionregions.models.Population;
import com.maliitourist.apigestionregions.apigestionregions.repository.PopulationRepository;
import com.maliitourist.apigestionregions.apigestionregions.services.PopulationService;

public class PopulationServiceImpl implements PopulationService {
    @Autowired
    PopulationRepository Repos;

    @Override
    public Population savePopulation(Population p) {
        // TODO Auto-generated method stub
        return Repos.save(p);
    }

    @Override
    public Population updatePopulation(Population p) {
        // TODO Auto-generated method stub
        return Repos.save(p);
    }

    @Override
    public void deletePopulation(Population p) {
        Repos.delete(p);
        
    }

    @Override
    public List<Population> getAllPopulation() {
       
        return Repos.findAll();
    }
    
}
