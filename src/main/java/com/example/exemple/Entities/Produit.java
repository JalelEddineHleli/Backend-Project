package com.example.exemple.Entities;

import com.example.exemple.DTO.categoriesdto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
  //  @JsonProperty("Price")
    private double prix;
  //  @JsonProperty("Quantite")
    private double quantite;

   // @JsonProperty("category")
    @ManyToOne(cascade = CascadeType.PERSIST)  // Ajoutez le cascade
  //  @JoinColumn(name = "cat_id")
    @JsonIgnore
    private Categories cat;
    @ManyToOne
 //   @JoinColumn(name = "promotion_id")
    private promotion promo;
    private String logoimg;
    @Transient
   private String catname;

    @OneToOne(mappedBy = "produit", cascade = CascadeType.ALL)
    private avis_produit avis_produit;
    @OneToOne(mappedBy = "produit", cascade = CascadeType.ALL)
    private productdetail productdetail;

public String getCatname(){
    return cat.getNom();
}








    public Double getPriceAfterDiscount() {
        if (promo != null && promo.isActive()) {
            Double discountedPrice = prix;


                discountedPrice -= discountedPrice * (promo.getDiscount() / 100);



            return discountedPrice;
        }
        return prix;
    }






    }



