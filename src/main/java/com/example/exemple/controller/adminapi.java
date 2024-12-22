package com.example.exemple.controller;

import com.example.exemple.DTO.productdto;
import com.example.exemple.DTO.productmapper;
import com.example.exemple.Entities.*;
import com.example.exemple.Entities.SousEntities.color;
import com.example.exemple.Entities.SousEntities.size;
import com.example.exemple.Entities.authEntities.appuser;
import com.example.exemple.repository.authrepo.appuserrepo;
import com.example.exemple.repository.categorieRepository;
import com.example.exemple.repository.colorrepo;
import com.example.exemple.repository.productRepository;
import com.example.exemple.repository.sizerepo;
import com.example.exemple.services.avis_produitService;
import com.example.exemple.services.productService;
import com.example.exemple.services.productdetailService;
import com.example.exemple.services.promotionservice;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/adminapi")
@CrossOrigin(origins = "http://localhost:4200")
public class adminapi {

    private productService service;
    private productRepository repo;

    private productdetailService pds;
    private categorieRepository catrepo;
    private sizerepo sizerepo;
    private colorrepo colorrepo;
    private appuserrepo appuserrepo;
    private promotionservice promotionService;
    private productmapper prmapper;


    ////////USER CRUUD///////////




    @GetMapping("/users")
    public List<appuser> getusers() {
        return appuserrepo.findAll();
    }



    // PRODUCT   CRUD ////////////////////////////////
  /*  @GetMapping("/products/getproducts")
    public List<productdto>  getallproducts(){
      return   service.getAllProducts();
    }
    @GetMapping("/products/getproducts/{id}")
    public Produit getproduct(@PathVariable("id") int id){
        return   service.getProduct(id);
    }*/
  /*  @GetMapping("/product/getproduct/{mc}")
    public List<Produit> getproduct(@PathVariable("mc") String mc){
        return repo.findByNomContainingOrCatNomContaining(mc,mc);

    }*/
    @DeleteMapping("/products/delete/{id}")
    public void deleteproduct(@PathVariable("id") int id){
        service.deleteProduct(id);
    }

    @PostMapping("/products/create")
    public void createproduct(@RequestParam("produit") String produitJson, @RequestParam("mf") MultipartFile mf) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Produit produit = objectMapper.readValue(produitJson, Produit.class);
        service.addProduct(produit, mf);
    }
    @PutMapping("/products/update/{id}")
    public void updateproduct(@RequestBody Produit produit,@PathVariable long id ){
            service.updateProduct(produit,id);
    }

   /* @GetMapping(path = "/products/getimage/{id}" ,produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getimage(@PathVariable("id") int id) throws IOException {
        return service.getProductImage(id);
    }*/





    //// CATEGORIE CRUD //////////////////////////
    @PostMapping("/categorie/addcat")
    public void  ajoutcat (@RequestBody Categories cat){
        catrepo.save(cat);
    }

    @GetMapping("/categorie/getcat")
    public List<Categories>  getcat (){
        return   catrepo.findAll();
    }
    @DeleteMapping("/categorie/deletecat/{id}")
    public void deletecat(@PathVariable("id") int id){
        catrepo.deleteById(id);
    }





    ///////////// SIZE CRUD ///////////
    @PostMapping("/size/addsize")
    public void  ajoutsize (@RequestBody size size){
        sizerepo.save(size);
    }
    @GetMapping("/size/getsize")
    public List<size>  getsize (){
            return  sizerepo.findAll();
    }
    @DeleteMapping("/size/deletesize/{id}")
    public void deletesize(@PathVariable("id") int id){
        sizerepo.deleteById(id);
    }




    //////////////COLOR CRUD ////////////
    @PostMapping("/color/addcolor")
    public void  ajoutcolor (@RequestBody color color){
        colorrepo.save(color);
    }
    @GetMapping("/color/getcolor")
    public List<color>  getcolor (){
        return  colorrepo.findAll();
    }
    @DeleteMapping("/color/deletecolor/{id}")
    public void deletecolor(@PathVariable("id") int id){
        colorrepo.deleteById(id);
    }




    ////////////PROMOTION CRUD ////////
    @PostMapping("/promotion/addpromo")
    public promotion createPromotion(@RequestBody promotion promotion) {
        promotion createdPromotion = promotionService.createPromotion(promotion);
        return promotion;
    }

    @GetMapping("/promotion/getpromo/{id}")
    public promotion getPromotionById(@PathVariable int id) {
        promotion promotion = promotionService.getPromotionById(id).get();

        return promotion;
    }


    @GetMapping("/promotion/getpromo")
    public List<promotion> getAllPromotions() {
        return promotionService.getAllPromotions();
    }

    @PutMapping("/promotion/update/{id}")
    public promotion updatePromotion(@PathVariable int id, @RequestBody promotion promotionDetails) {
        promotion updatedPromotion = promotionService.updatePromotion(id, promotionDetails);
        return updatedPromotion;
    }


    @DeleteMapping("/promotion/delete/{id}")
    public void deletePromotion(@PathVariable int id) {
        promotionService.deletePromotion(id);
    }

    /*@GetMapping("/price/{productId}")
    public Double getPriceAfterDiscount(@PathVariable Long productId) {
        return service.getPriceAfterDiscount(productId);
    }*/
    @PutMapping("/promotion/{productId}/promotion/{promotionId}")
    public Produit addPromotionToProduct(
            @PathVariable Long productId,
            @PathVariable int promotionId) {
        Produit updatedProduct = service.addPromotionToProduct(productId, promotionId);
        return updatedProduct;
    }




    ///////PRODUCT DETAILS////////////
    @PostMapping("/productdetail/addproductdetail/{productid}")
    public void addavis (@PathVariable int productid , @RequestBody productdetail pd){
        pds.addproductdetail(productid,pd);

    }
    }










