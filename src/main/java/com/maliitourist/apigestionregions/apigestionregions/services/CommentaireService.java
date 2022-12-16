package com.maliitourist.apigestionregions.apigestionregions.services;

import java.util.List;

import com.maliitourist.apigestionregions.apigestionregions.models.Commentaire;

public interface CommentaireService {
    
    // Methode pour la création d'un commentaire
    Commentaire saveCommentaire(Commentaire c);

    // Methode pour la modification d'un commentaire
    Commentaire updateCommentaire(Commentaire c);

    // Methode pour la surpression d'un commentaire à partir d'un commentaire
    void deleteCommentaire(Commentaire c);

    // Methode pour la liste des commentaires à partir d'un commentaire
    List<Commentaire> getAllCommentaire();

}
