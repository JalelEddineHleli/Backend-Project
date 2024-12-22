package com.example.exemple.controller;

import com.example.exemple.DTO.productdto;
import com.example.exemple.Entities.Categories;
import com.example.exemple.Entities.Produit;
import com.example.exemple.Entities.avis_produit;
import com.example.exemple.Entities.productdetail;
import com.example.exemple.repository.categorieRepository;
import com.example.exemple.repository.productRepository;
import com.example.exemple.services.avis_produitService;
import com.example.exemple.services.productService;
import com.example.exemple.services.productdetailService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
/*
@PreAuthorize("hasAuthority('ADMIN')")
*/
@RequestMapping("/userapi")
public class userapi {
    private avis_produitService avisservice;
    private productService service;
    private productdetailService pds;
    private productRepository repo;
    private categorieRepository catrepo;
    ////// AVIS PRODUCT CRUD///////////
/*
    @PreAuthorize("hasAuthority('ADMIN')")
*/
    @PostMapping("/avis/addavis/{productid}")
    public void addavis (@PathVariable int productid , @RequestBody @Valid avis_produit avis){
        avisservice.ajouteravis(productid, avis.getAvisSurDix());
    }
/*
    @PreAuthorize("hasAuthority('ADMIN')")
*/
    @GetMapping("/avis/getavis/{productid}")
    public Optional<avis_produit> getavis (@PathVariable int productid  ){
        return   avisservice.getavis(productid);
    }
    // PRODUCT_DETAILS CRUD ///////////////////

    @GetMapping("/productdetail/getproductdetail/{productid}")
    public productdetail getproductdetail (@PathVariable int productid  ){
        return   pds.getproductdetail(productid);
    }

    // PRODUCT   CRUD ////////////////////////////////
    @GetMapping("/products/getproducts")
    public List<productdto> getallproducts(){
        return   service.getAllProducts();
    }
    @GetMapping("/products/getproducts/{id}")
    public Produit getproduct(@PathVariable("id") int id){
        return   service.getProduct(id);
    }
    @GetMapping("/product/getproduct/{mc}")
    public List<Produit> getproduct(@PathVariable("mc") String mc){
        return repo.findByNomContainingOrCatNomContaining(mc,mc);
    }
    @GetMapping(path = "/products/getimage/{id}" ,produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getimage(@PathVariable("id") int id) throws IOException {
        return service.getProductImage(id);
    }
    @GetMapping("/products/getproductsbycategorie/{catid}")
    public List<Produit> getproductsbycategorie (@PathVariable int catid ){
        return service.getproductsbycategorie(catid);
    }
    //////// CATEGORIE CRUD /////////
    @GetMapping("/categorie/getcat")
    public List<Categories>  getcat (){
        return   catrepo.findAll();
    }

}
