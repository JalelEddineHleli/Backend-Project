package com.example.exemple.services;

import com.example.exemple.Entities.promotion;
import com.example.exemple.repository.promotionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class promotionservice {
    private promotionRepository repo;
    public promotion createPromotion(promotion promotion) {
        return repo.save(promotion);
    }

    // Lire une promotion par son ID
    public Optional<promotion> getPromotionById(int id) {
        return repo.findById(id);
    }

    // Lire toutes les promotions
    public List<promotion> getAllPromotions() {
        return repo.findAll();
    }

    // Mettre à jour une promotion
    public promotion updatePromotion(int id, promotion promotionDetails) {
        promotion promotion = repo.findById(id).get();


        promotion.setDiscount(promotionDetails.getDiscount());
        promotion.setStartDate(promotionDetails.getStartDate());
        promotion.setEndDate(promotionDetails.getEndDate());
        return repo.save(promotion);
    }

    // Supprimer une promotion
    public void deletePromotion(int id) {
        promotion promotion = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Promotion not found with id " + id));
        repo.delete(promotion);
    }
}
