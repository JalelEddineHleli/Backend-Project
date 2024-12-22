package com.example.exemple.repository;

import com.example.exemple.Entities.Categories;
import com.example.exemple.Entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface productRepository extends JpaRepository<Produit, Long> {
    public Page<Produit> findByNomContainingOrCatNomContaining(String nom, String catNom, Pageable p);
    public List<Produit> findByNomContainingOrCatNomContaining(String nom, String catNom);
    public List<Produit> findByPrix(Double prix);
    public List<Produit> findByCat(Categories cat);
}
