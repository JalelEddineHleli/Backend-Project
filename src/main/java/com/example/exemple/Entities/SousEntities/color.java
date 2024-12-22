package com.example.exemple.Entities.SousEntities;

import com.example.exemple.Entities.productdetail;
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
public class color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String color;
    @ManyToMany(mappedBy = "existedColors")
    @JsonIgnore
    private List<productdetail> productDetails;
}