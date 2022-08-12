package com.maliitourist.apigestionregions.apigestionregions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maliitourist.apigestionregions.apigestionregions.models.Population;

@Service
public interface PopulationService {
    Population savePopulation(Population p);
    Population updatePopulation(Population p);
    void deletePopulation(Population p);
    List<Population> getAllPopulation();

    
}
