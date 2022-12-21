package com.maliitourist.apigestionregions.apigestionregions.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maliitourist.apigestionregions.apigestionregions.configuration.SpringSecurity.Jwt.JwtUtils;
import com.maliitourist.apigestionregions.apigestionregions.configuration.SpringSecurity.Services.UserDetailsImpl;
import com.maliitourist.apigestionregions.apigestionregions.message.request.LoginRequest;
import com.maliitourist.apigestionregions.apigestionregions.message.response.JwtResponse;
import com.maliitourist.apigestionregions.apigestionregions.message.response.ResponseMessage;
import com.maliitourist.apigestionregions.apigestionregions.models.Admin;
import com.maliitourist.apigestionregions.apigestionregions.repository.RoleRepository;
import com.maliitourist.apigestionregions.apigestionregions.servicesImplementation.AdminServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@Api(value = "admin", description = "Les actions de l'administrateur")
@RequestMapping("/admin")
@RestController
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;
    
    // @Autowired
    // private OAuth2AuthorizedClientService loadAuthorizedClientService;


    @Autowired
    private AdminServiceImpl service;

    // methode pour la création d'un Admin
    @PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Création d'un administrateur.")
    @PostMapping("/creer")
    public ResponseEntity<Object> CreerAdmin(@RequestBody Admin Admin) {

        Admin EnregistreAdmin = service.saveAdmin(Admin);
        return ResponseMessage.generateResponse("Admin ajouté avec succes", HttpStatus.OK, EnregistreAdmin);

    }
    // Fin

    // methode pour le login d'un Admin
    @ApiOperation(value = "Le login d'un Administrateur.")
    @PostMapping("/login")
    public ResponseEntity<Object> Login(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList());

        //Admin EnregistreAdmin = service.saveAdmin(Admin);
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getNom(), userDetails.getPrenom(), roles));

    }
    // Fin

    // methode pour la mise à jour d'un Admin
    @PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Mis à jour d'un administrateur.")
    @PutMapping("/mettreajour")
    public ResponseEntity<Object> MiseAJourAdmin(@RequestBody Admin Admin) {

        Admin EnregistreAdmin = service.updateAdmin(Admin);
        return ResponseMessage.generateResponse("Admin modifié avec succes", HttpStatus.OK, EnregistreAdmin);

    }
    // Fin

    // methode pour la surpression d'un Admin
    @PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Surpression d'un administrateur.")
    @DeleteMapping("/suprimer")
    public ResponseEntity<Object> SuprimerAdmin(@RequestBody Admin Admin) {

        try {
            service.deleteAdmin(Admin);
            return ResponseMessage.generateResponse("Admin suprimer!", HttpStatus.OK, null);

        } catch (Exception e) {
            return ResponseMessage.generateResponse("Erreur lors de la surpression.", HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la liste des Admin
    @ApiOperation(value = "Récuperation de la liste des administrateurs.")
    @PreAuthorize ("hasRole('ROLE_ADMIN')")
    @GetMapping("/liste")
    public ResponseEntity<Object> ListeAdmin(Authentication authentication) {

        try {
            return ResponseMessage.generateResponse("La liste des admins:", HttpStatus.OK, service.getAllAdmin());

        } catch (Exception e) {
            return ResponseMessage.generateResponse("Erreur lors du retour de la liste.", HttpStatus.OK, null);
        }

    }
    // Fin
}
