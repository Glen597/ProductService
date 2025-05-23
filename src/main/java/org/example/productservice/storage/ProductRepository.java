package org.example.productservice.storage;

import java.util.*;

import org.example.productservice.model.Product;

public class ProductRepository
{
    private static final Map<Integer, Product> Products= new HashMap<>();
    private static int idCounter = 1;

    public Collection<Product> getAllProducts(){
        return Products.values();
    }

    public Product getProductById(int id){
        return Products.get(id);
    }

    public Product getProductByName(String productName){
        for(Product product: Products.values()){
            if(product.getName().equals(productName)){
                return product;
            }

        }
        return null;
    }

    public Product addProduct(Product product){
        product.setId(idCounter ++);
        Products.put(product.getId(), product);
        return product;
    }

    public Product updateProduct(int id,Product product){
        if(!Products.containsKey(id)){
            System.out.println("Product not found");
            return null;
        }
        product.setId(id);
        Products.put(id, product);
        return product;
    }

    public Product updateProductPrice( int id,int price){

        if(!Products.containsKey(id)){
            System.out.println("Product not found");
            return null;
        }

        Product existingProduct = Products.get(id);
       existingProduct.setPrice(price);
       return existingProduct;
    }

    public boolean deleteProduct(int id){

        return Products.remove(id) != null;
    }
}
