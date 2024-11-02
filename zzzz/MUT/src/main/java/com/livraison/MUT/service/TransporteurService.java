package com.livraison.MUT.service;

import com.livraison.MUT.entities.Transporteur;
import com.livraison.MUT.repository.TransporteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransporteurService {
    @Autowired
    private TransporteurRepository transporteurRepository;

    public List<Transporteur> getAllTransporteurs() {

        return transporteurRepository.findAll();
    }

    public void saveTransporteur(Transporteur transporteur) {

        transporteurRepository.save(transporteur);
    }

    public Transporteur getTransporteurById(int id) {
        return transporteurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid transporteur Id:" + id));
    }


    public void deleteTransporteur(Integer id) {
        Transporteur transporteur = getTransporteurById(id);
        transporteurRepository.delete(transporteur);
    }

    public List<Transporteur> rechercherParNom(String nom) {
        return transporteurRepository.findByNomContainingIgnoreCase(nom);
    }


    public void updateTransporteur(Integer id, Transporteur transporteur) throws Exception {
        Transporteur existingTransporteur = getTransporteurById(id);
        if (existingTransporteur == null) {
            throw new Exception("Transporteur non trouvé");
        }

        existingTransporteur.setNom(transporteur.getNom());
        existingTransporteur.setVehicul(transporteur.getVehicul());

        saveTransporteur(existingTransporteur);
    }


}

