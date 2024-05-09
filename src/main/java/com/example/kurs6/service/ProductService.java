package com.example.kurs6.service;

import com.example.kurs6.dto.ProductDTO;
import com.example.kurs6.entity.Product;
import com.example.kurs6.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productrepository;

    public Product create(ProductDTO dto){
        Product product = Product.builder()
                .name(dto.getName())
                .amount(dto.getAmount())
                .build();
        return productrepository.save(product);
    }


    public List<Product> readAll(){
        return productrepository.findAll();
    }

    public Product update(Product product){
        return productrepository.save(product);
    }

    public void delete(Long id){
        productrepository.deleteById(id);
    }
}
