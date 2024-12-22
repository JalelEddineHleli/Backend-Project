package com.example.exemple.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class avis_produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "avis_sur_dix")
    @Min(0)
    @Max(10)
    private Integer avisSurDix;

    @OneToOne
    @JoinColumn(name = "produit_id")
    @JsonIgnore
    private Produit produit;
}
