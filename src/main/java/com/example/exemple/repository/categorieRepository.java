package com.example.exemple.repository;

import com.example.exemple.Entities.Categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categorieRepository extends JpaRepository<Categories, Integer> {
    Categories findById(int id);
    Categories findByNom(String nom);  }

