package com.livraison.MUT.service;

import com.livraison.MUT.entities.Livraison;
import com.livraison.MUT.entities.Transporteur;
import com.livraison.MUT.repository.LivraisonRepository;
import com.livraison.MUT.repository.TransporteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LivraisonService {

    @Autowired
    private LivraisonRepository livraisonRepository;

    @Autowired

    private TransporteurRepository transporteurRepository;

    public List<Livraison> getAllLivraisons() {

        return livraisonRepository.findAll();
    }

    public List<Transporteur> getAllTransporteurs() {

        return transporteurRepository.findAll();
    }


    public void updateLivraison(Livraison livraison, int id) {

        if (livraison.getTransporteur() != null && livraison.getTransporteur().getId() != null) {
            Transporteur transporteur = transporteurRepository.findById(livraison.getTransporteur().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid transporteur Id:" + livraison.getTransporteur().getId()));
            livraison.setTransporteur(transporteur);
        }


        livraisonRepository.save(livraison);
    }

    public Livraison getLivraisonById(Integer id) {
        return livraisonRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Livraison Id:" + id));
    }

    public void saveLivraison(Livraison livraison, Integer idTransporteur) {

        if (idTransporteur != null && idTransporteur != 0) {
            Transporteur transporteur = transporteurRepository.findById(idTransporteur).orElse(null);
            if (transporteur != null) {
                livraison.setTransporteur(transporteur);
            } else {
                throw new IllegalArgumentException("Invalid Transporteur ID: " + idTransporteur);
            }
        }


        livraisonRepository.save(livraison);
    }


    public void deleteLivraison(Integer id) {
        Livraison livraison = getLivraisonById(id);
        livraisonRepository.delete(livraison);
    }

    public List<Livraison> getLivraisonsByTransporteurId(Integer id) {
        return livraisonRepository.findByTransporteurId(id);
    }


    public List<Livraison> getLivraisonsByDate(LocalDate date) {

        return livraisonRepository.findByDate(date);
    }

}
