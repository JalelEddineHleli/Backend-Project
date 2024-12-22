package com.example.exemple.services;

import com.example.exemple.DTO.productdto;
import com.example.exemple.Entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IproductService {
    public void addProduct(Produit p ,MultipartFile mf) throws IOException ;
    public void updateProduct(Produit p, long id );
    public void deleteProduct(long id);
    public Produit getProduct(long id);
    public List<productdto>  getAllProducts();
    public Page<Produit> getProductsByMC(String mc, Pageable p );
    public List<Produit> getProductsByPrix(Double prix);
public byte[] getProductImage(long id) throws IOException;
    public Double getPriceAfterDiscount(Long productId);
}
