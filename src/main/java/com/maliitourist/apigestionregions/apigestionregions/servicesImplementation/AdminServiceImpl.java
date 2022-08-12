package com.maliitourist.apigestionregions.apigestionregions.servicesImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maliitourist.apigestionregions.apigestionregions.models.Admin;
import com.maliitourist.apigestionregions.apigestionregions.repository.AdminRepository;
import com.maliitourist.apigestionregions.apigestionregions.services.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository repos;

    @Override
    public Admin saveAdmin(Admin a) {
        // TODO Auto-generated method stub
        return repos.save(a);
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

}
