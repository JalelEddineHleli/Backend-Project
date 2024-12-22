package com.example.exemple.services;

import com.example.exemple.Entities.Produit;
import com.example.exemple.Entities.avis_produit;
import com.example.exemple.repository.avis_produitRepository;
import com.example.exemple.repository.productRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class avis_produitService {
    private avis_produitRepository repo;
    private productService service;
    private productRepository pr;
    public void ajouteravis(int produitId,  Integer avis){
        Produit p = service.getProduct(produitId);
        avis_produit monavis = avis_produit.builder()
                .produit(p)
                .avisSurDix(avis)
                .build();
        repo.save(monavis);



    }
    public Optional<avis_produit> getavis(int produitId){
        Produit p = service.getProduct(produitId);
        return Optional.ofNullable(p.getAvis_produit());

    }
}
