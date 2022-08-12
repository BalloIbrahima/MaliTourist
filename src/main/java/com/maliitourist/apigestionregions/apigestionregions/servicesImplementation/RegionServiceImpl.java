package com.maliitourist.apigestionregions.apigestionregions.servicesImplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maliitourist.apigestionregions.apigestionregions.models.Region;
import com.maliitourist.apigestionregions.apigestionregions.repository.RegionRepository;
import com.maliitourist.apigestionregions.apigestionregions.services.RegionService;

@Service
public class RegionServiceImpl implements RegionService {

    RegionRepository repos;

    @Override
    public Region saveRegion(Region a) {
        // TODO Auto-generated method stub
        return repos.save(a);
    }

    @Override
    public Region updateRegion(Region a) {
        // TODO Auto-generated method stub
        return repos.save(a);
    }

    @Override
    public void deleteRegion(Region a) {
        // TODO Auto-generated method stub
        repos.delete(a);
    }

    @Override
    public List<Region> getAllRegion() {
        // TODO Auto-generated method stub
        return repos.findAll();
    }

    @Override
    public Region getRegionByNom(String nom) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Region getRegion(Region a) {
        // TODO Auto-generated method stub
        return null;
    }

}
