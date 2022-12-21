package com.maliitourist.apigestionregions.apigestionregions.servicesImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maliitourist.apigestionregions.apigestionregions.configuration.SpringSecurity.SpringSecurity;
import com.maliitourist.apigestionregions.apigestionregions.models.Admin;
import com.maliitourist.apigestionregions.apigestionregions.repository.AdminRepository;
import com.maliitourist.apigestionregions.apigestionregions.services.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository repos;

    @Autowired
    SpringSecurity security;

    @Override
    public Admin saveAdmin(Admin user) {
        // TODO Auto-generated method stub


        // Create new user's account
        // User user = new User(signUpRequest.getUsername(),
        //     //signUpRequest.getEmail(),
        //     encoder.encode(signUpRequest.getPassword()))
        //     ;
        // log.info("Utilisateur crée" + user);
        // Set<String> strRoles = signUpRequest.getRole();
        // Set<Role> roles = new HashSet<>();

        // if (strRoles == null) {
        // Role userRole = roleRepository.findByName(ERole.ROLE_USER)
        //     .orElseThrow(() -> new RuntimeException("Erreur: Role nom trouver."));
        // log.info("role non trouvé" + userRole);
        // roles.add(userRole);
        // } else {
        // strRoles.forEach(role -> {
        //     switch (role) {
        //     case "admin":
        //         Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
        //             .orElseThrow(() -> new RuntimeException("Erreur: Role nom trouver."));
        //         roles.add(adminRole);
        //         break;
        //     default:
        //         Role userRole = roleRepository.findByName(ERole.ROLE_USER)
        //             .orElseThrow(() -> new RuntimeException("Erreur: Role nom trouver."));
        //         roles.add(userRole);
        //     }
        // });
        // }

        // user.setRoles(roles);
        return repos.save(user);
        // log.info("Utilisateur crée " + user.getUsername());

    }

    @Override
    public Admin updateAdmin(Admin a) {
        // TODO Auto-generated method stub
        return repos.save(a);
    }

    @Override
    public void deleteAdmin(Admin a) {
        // TODO Auto-generated method stub
        repos.delete(a);
    }

    @Override
    public List<Admin> getAllAdmin() {
        // TODO Auto-generated method stub
        return repos.findAll();
    }

    @Override
    public Admin getByUsername(String username) {
        // TODO Auto-generated method stub
        try {
            return repos.findByUsername(username).get();
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

}
