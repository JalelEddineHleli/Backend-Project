package com.example.exemple.DTO;

import com.example.exemple.Entities.Categories;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class productdto {
    private String nom;
    private double prix;
    private double quantite;
    private String catname;
    //private Categories category;
    private String logoimg;
    //private int catid;





}
