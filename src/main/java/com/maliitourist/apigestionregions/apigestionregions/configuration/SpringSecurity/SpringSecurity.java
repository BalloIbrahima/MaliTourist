package com.maliitourist.apigestionregions.apigestionregions.configuration.SpringSecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@Configuration
@EnableGlobalMethodSecurity(
    prePostEnabled = true)
public class SpringSecurity {
    
}
