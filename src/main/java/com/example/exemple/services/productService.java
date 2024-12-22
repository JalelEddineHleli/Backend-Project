package com.example.exemple.services;

import com.example.exemple.DTO.productdto;
import com.example.exemple.DTO.productmapper;
import com.example.exemple.Entities.Categories;
import com.example.exemple.Entities.Produit;
import com.example.exemple.Entities.promotion;
import com.example.exemple.repository.categorieRepository;
import com.example.exemple.repository.productRepository;
import com.example.exemple.repository.promotionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class productService implements com.example.exemple.services.IproductService {

    private productmapper prmapper;
    private categorieRepository crepo;

    private promotionRepository prrepo;
    @Autowired
    private productRepository pr;


    @Override
    public void updateProduct(Produit p, long id ) {
     Produit p1 =  pr.findById(id).get();

        if (p.getNom() != null) {
            p1.setNom(p.getNom());
        }
        if (p.getCat() != null) {
            p1.setCat(p.getCat());
        }
        if (p.getPrix() != 0) {
            p1.setPrix(p.getPrix());
        }
        if (p.getLogoimg() != null) {
            p1.setLogoimg(p.getLogoimg());
        }
        if (p.getQuantite() != 0) {
            p1.setQuantite(p.getQuantite());
        }

        pr.save(p1);
    }

    @Override
    public void deleteProduct(long id) {
pr.deleteById(id);
    }

    @Override
    public Produit getProduct(long id) {
       return  pr.findById(id).get() ;
    }

    @Override
    public List<productdto> getAllProducts() {
        List<Produit> produits = this.pr.findAll();
        List<productdto> p1 = prmapper.productToProductDTO(produits);


        return prmapper.productToProductDTO(produits);
    }


    @Override
    public Page<Produit> getProductsByMC(String mc, Pageable p ) {
        return pr.findByNomContainingOrCatNomContaining(mc,mc,p) ;
    }
    public List<Produit> getProductsByPrix(Double prix) {
        return pr.findByPrix(prix);
    }

    @Override
    public byte[] getProductImage(long id) throws IOException {
        String nomimage= pr.findById(id).get().getLogoimg();
        Path path = Paths.get("src/main/resources/static/images", nomimage);
        return Files.readAllBytes(path);
    }


    private String newname(String oldname) {
        String firstname = oldname.substring(0, oldname.lastIndexOf("."));
        String secondname = oldname.substring(oldname.lastIndexOf(".") + 1);
        String newname = firstname + LocalDateTime.now().toString().replace(":", "-") + "." + secondname;
        return newname;
    }

    public String uploadImage(MultipartFile mf) throws IOException {
        String oldName = mf.getOriginalFilename();
        String newName = newname(oldName);
        //Path p = Paths.get("C:/uploaded-images", newName);
       Path p= Paths.get("src/main/resources/static/images", newName);
       /* if (!Files.exists(p.getParent())) {
            Files.createDirectories(p.getParent());
        }*/
        Files.write(p, mf.getBytes());


        return newName;
}
    @Override
    public void addProduct(Produit p1, MultipartFile mf) throws IOException {
        if(!mf.isEmpty())
            p1.setLogoimg(uploadImage(mf));

        Categories category = crepo.findById(p1.getCat().getId());

        p1.setCat(category);

        pr.save(p1);
    }
    public Double getPriceAfterDiscount(Long productId) {
        Produit product = pr.findById(productId).get();
        return product.getPriceAfterDiscount();
    }
    public Produit addPromotionToProduct(Long productId, int promotionId) {

        Produit product = pr.findById(productId).get();

        promotion promotion = prrepo.findById(promotionId).get();



        product.setPromo(promotion);
        product.setNom(product.getNom() + " #Article_Promotionné ");
        product.setPrix(getPriceAfterDiscount(productId));


        return pr.save(product);
    }
    public List<Produit> getproductsbycategorie(int cat_id ){
       Categories mycat =  crepo.findById(cat_id);
      return pr.findByCat(mycat);
    }



}
