package org.example.productservice.service;


import org.example.productservice.model.Product;
import org.example.productservice.storage.ProductRepository;

import java.util.*;


public class ProductService {
    private final ProductRepository repository = new ProductRepository() ;


    public Product getProductByID(int id){
        return repository.getProductById(id);
    }

    public Product getProductByNAme(String Name){
        return repository.getProductByName(Name);
    }
    public Collection<Product> getAllProducts(){
        return repository.getAllProducts();
    }

    public Product addProduct(Product product){
        return repository.addProduct(product);
    }

    public Product updateProduct(int id,Product product){
        return repository.updateProduct(id, product);
    }

    public Product updateProductPrice(int id, int price){
        return repository.updateProductPrice(id, price);
        }

    public boolean deleteProduct(int id){
        return repository.deleteProduct(id);
    }

}
