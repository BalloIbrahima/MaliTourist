package com.maliitourist.apigestionregions.apigestionregions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maliitourist.apigestionregions.apigestionregions.models.Admin;

@Service
public interface AdminService {
    // Methode pour la création d'un admin
    Admin saveAdmin(Admin a);

    // Methode pour la modification d'un admin
    Admin updateAdmin(Admin a);

    // Methode pour la surpression d'un admin à partir d'un admin
    void deleteAdmin(Admin a);

    // Methode pour la liste des admins à partir d'un admin
    List<Admin> getAllAdmin();

}
