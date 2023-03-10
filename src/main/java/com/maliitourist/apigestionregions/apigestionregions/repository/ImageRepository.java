package com.maliitourist.apigestionregions.apigestionregions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maliitourist.apigestionregions.apigestionregions.models.Image;
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    
}
