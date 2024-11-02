package com.livraison.MUT.repository;

import com.livraison.MUT.entities.Livraison;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface LivraisonRepository extends JpaRepository<Livraison, Integer> {
    List<Livraison> findByTransporteurId(Integer id);
    List<Livraison> findByDate(LocalDate date);
}
