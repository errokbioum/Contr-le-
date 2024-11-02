package com.livraison.MUT.repository;

import com.livraison.MUT.entities.Livraison;
import com.livraison.MUT.entities.Transporteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransporteurRepository extends JpaRepository<Transporteur, Integer> {
    List<Transporteur> findByNomContainingIgnoreCase(String nom);


}
