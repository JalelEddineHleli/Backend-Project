package com.example.exemple.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Double discount;
    private LocalDate startDate;
    private LocalDate endDate;
    @OneToMany(mappedBy = "promo", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Produit> products;
    public boolean isActive() {
        LocalDateTime now = LocalDateTime.now();
        return (startDate.isBefore(ChronoLocalDate.from(now))
                || startDate.isEqual(ChronoLocalDate.from(now)))
                && (endDate.isAfter(ChronoLocalDate.from(now))
                || endDate.isEqual(ChronoLocalDate.from(now)));
    }
}
