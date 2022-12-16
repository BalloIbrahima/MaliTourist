package com.maliitourist.apigestionregions.apigestionregions.servicesImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maliitourist.apigestionregions.apigestionregions.models.Commentaire;
import com.maliitourist.apigestionregions.apigestionregions.repository.CommentaireRepository;
import com.maliitourist.apigestionregions.apigestionregions.services.CommentaireService;

@Service
public class CommentaireServiceImpl implements CommentaireService{

    @Autowired
    CommentaireRepository repos;

    @Override
    public Commentaire saveCommentaire(Commentaire c) {
        // TODO Auto-generated method stub
        return repos.save(c);
    }

    @Override
    public Commentaire updateCommentaire(Commentaire c) {
        // TODO Auto-generated method stub
        return repos.save(c);
    }

    @Override
    public void deleteCommentaire(Commentaire c) {
        // TODO Auto-generated method stub
        repos.delete(c);
        
    }

    @Override
    public List<Commentaire> getAllCommentaire() {
        // TODO Auto-generated method stub
        return repos.findAll();
    }
    
}
