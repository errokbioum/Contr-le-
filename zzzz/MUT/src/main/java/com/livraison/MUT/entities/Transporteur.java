package com.livraison.MUT.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Transporteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message ="le nom est obligatoire")
    private String nom;
    private String vehicul;
    @OneToMany(fetch = FetchType.EAGER ,   mappedBy = "transporteur")
    private List<Livraison> livraisons;
}
