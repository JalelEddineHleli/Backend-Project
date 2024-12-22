package com.example.exemple.Entities;

import com.example.exemple.Entities.SousEntities.color;
import com.example.exemple.Entities.SousEntities.size;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class productdetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;


   @ManyToMany

    private List<color> existedColors;
    @ManyToMany


    private List<size> existedSize;











    private String marque;

    @OneToOne
    @JoinColumn(name = "produit_id")
    @JsonIgnore
    private Produit produit;

}
