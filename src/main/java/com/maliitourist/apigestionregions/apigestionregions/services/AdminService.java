package com.maliitourist.apigestionregions.apigestionregions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maliitourist.apigestionregions.apigestionregions.models.User;

@Service
public interface AdminService {
    // Methode pour la création d'un admin
    User saveAdmin(User a);

    // Methode pour la modification d'un admin
    User updateAdmin(User a);

    // Methode pour la surpression d'un admin à partir d'un admin
    void deleteAdmin(User a);

    // Methode pour la liste des admins à partir d'un admin
    List<User> getAllAdmin();

}
