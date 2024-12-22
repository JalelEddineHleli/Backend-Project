package com.example.exemple.DTO;

import com.example.exemple.Entities.Categories;
import com.example.exemple.Entities.Produit;
import com.example.exemple.repository.categorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class productmapper {
    @Autowired
    categorieRepository cr;


    public List<productdto> productToProductDTO(List<Produit> produits) {
        List<productdto> productDTOList = new ArrayList<>();
        for (Produit produit : produits) {
            productDTOList.add(productToProductDTO(produit));
        }
        return productDTOList;
    }



    public Produit productDTOToProduit(productdto productDTO) {
        if (productDTO == null) {
            return null;
        }
        Produit produit = new Produit();

        produit.setNom(productDTO.getNom());
        produit.setPrix(productDTO.getPrix());
        produit.setQuantite(productDTO.getQuantite());
      // produit.setCat(categorieDTOTocategorie(productDTO.getCategory()));
        produit.setLogoimg(productDTO.getLogoimg());
        //produit.setCat(cr.findById(productDTO.getCatid()));
        //produit.setCatid(productDTO.getCatid());
        produit.setCat(cr.findByNom(productDTO.getCatname()));



        return produit;
    }


    public productdto productToProductDTO(Produit produit) {
        if (produit == null) {
            return null;
        }
        productdto productDTO = new productdto();

        productDTO.setNom(produit.getNom());
        productDTO.setPrix(produit.getPrix());
        productDTO.setQuantite(produit.getQuantite());
        productDTO.setLogoimg(produit.getLogoimg());
        if (produit.getCat() != null) {
            productDTO.setCatname(produit.getCat().getNom());
        } else {
            productDTO.setCatname("Catégorie non définie");  // Valeur par défaut ou gérer autrement
        }
       //productDTO.setCatname(produit.getCat().getNom());
       //productDTO.setCategory(produit.getCat());
       //productDTO.setCatname(cr.findById(productDTO.getCatid()).getNom());


        return productDTO;
    }
    public Categories categorieDTOTocategorie(categoriesdto categoriesdto) {

        Categories categories = new Categories();

        categories.setNom(categoriesdto.getNom());
        return categories;
    }
    public categoriesdto categorieTocategorieDTO(Categories categories) {

        categoriesdto categoriesdto = new categoriesdto();

        categoriesdto.setNom(categories.getNom());
        return categoriesdto;
    }
}
