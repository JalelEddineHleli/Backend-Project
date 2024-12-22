package com.example.exemple.repository;

import com.example.exemple.Entities.avis_produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface avis_produitRepository extends JpaRepository<avis_produit, Integer> {
    avis_produit findById(int id);
}
