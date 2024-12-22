package com.example.exemple.repository;

import com.example.exemple.Entities.promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface promotionRepository extends JpaRepository<promotion, Integer> {
}
