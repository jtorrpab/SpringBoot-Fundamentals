package com.market.domain.service;

import com.market.domain.dto.Product;
import com.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Optional<List<Product>> getScaseProducts(int quantity){
        return productRepository.getScaseProducts(quantity);
    }

    public  Product saveProduct(Product product){
        return productRepository.saveProduct(product);
    }

    public boolean deleteProduct (int productId){
        return productRepository.getProduct(productId).map(prod ->{
            productRepository.deleteProduct(productId);
            return true;
        }).orElse(false);
    }
}
