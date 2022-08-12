package com.maliitourist.apigestionregions.apigestionregions.services;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.maliitourist.apigestionregions.apigestionregions.models.Langue;

@Controller
public interface LangueService {
    Langue saveLangue(Langue l);
    Langue updateLangue(Langue l);
    void deleteLangue(Langue l);
    List<Langue> getAllLangue();
    
}
