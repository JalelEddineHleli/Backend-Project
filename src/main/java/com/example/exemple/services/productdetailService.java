package com.example.exemple.services;

import com.example.exemple.Entities.Produit;
import com.example.exemple.Entities.productdetail;
import com.example.exemple.repository.productdetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class productdetailService {
    private productdetailRepository productdetailRepository;
    private productService productService;
    public void addproductdetail(int id , productdetail pd){
        Produit p = productService.getProduct(id);
       productdetail detailprod= productdetail.builder()
                .description(pd.getDescription())
                .existedSize(pd.getExistedSize())
                .produit(p)
                .existedColors(pd.getExistedColors())
                .marque(pd.getMarque())
                .build();

        productdetailRepository.save(detailprod);

    }
    public productdetail getproductdetail(int productid){
        Produit p =productService.getProduct(productid);
        return p.getProductdetail();

    }
}
