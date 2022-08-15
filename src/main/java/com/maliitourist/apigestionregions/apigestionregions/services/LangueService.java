package com.maliitourist.apigestionregions.apigestionregions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maliitourist.apigestionregions.apigestionregions.models.Langue;

@Service
public interface LangueService {
    Langue saveLangue(Langue l);

    Langue updateLangue(Langue l);

    void deleteLangue(Langue l);

    List<Langue> getAllLangue();

    Langue findByLibele(String nom);

    // Methode pour recuperer le pays à travers le code
    Langue getLangueByCode(String code);

}
