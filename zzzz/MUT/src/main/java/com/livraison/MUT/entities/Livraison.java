package com.livraison.MUT.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Livraison {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
  @NotBlank( message ="adress est obligatoire  ")
   private String adresse;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
   private LocalDate date;
   private String client;
   @ManyToOne
   @JoinColumn(name ="transporteur",nullable = false)
   private Transporteur transporteur;



}
