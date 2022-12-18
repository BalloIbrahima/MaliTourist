package com.maliitourist.apigestionregions.apigestionregions.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/swagger")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SwaggerController {
    @RequestMapping(method = RequestMethod.GET)
    public String swagger() {
        return "redirect:/swagger-ui.html";
    }

}
