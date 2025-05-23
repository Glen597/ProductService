package org.example.productservice.controller;

import org.example.productservice.model.Product;
import java.util.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.*;
import org.example.productservice.service.ProductService;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    private final ProductService service = new ProductService();

    @GET
    @Path("/id/{id}")
    public Response getProduct(@PathParam("id") int id){
        Product product = service.getProductByID(id);
        if(product == null){
            return Response.status(Response.Status.NOT_FOUND).entity("Product not found for ID: " + id ).build();
        }
        return Response.status(Response.Status.OK).entity(product).build();
    }

    @GET
    @Path("/name/{name}")
    public Response getProductByName(@PathParam("name") String name){

        Product product = service.getProductByNAme(name);
        if(product == null){
            return Response.status(Response.Status.NOT_FOUND).entity("Product Not found for Name: " + name).build();
        }
      return Response.status(Response.Status.OK).entity(product).build();
    }

    @GET
    public Collection<Product> getProducts(){
        return service.getAllProducts();
    }

    @POST
    public Response addProduct(Product product){

        Product created = service.addProduct(product);
        return Response.status(Response.Status.CREATED).entity(created).build();

    }

    @PUT
    @Path("/id/{id}")
    public Response updateProduct(@PathParam("id") int id, Product product){
        Product update = service.updateProduct( id, product);
        if(update == null){
            return Response.status(Response.Status.NOT_FOUND).entity("Product not found for ID: " + id ).build();
        }
        return Response.status(Response.Status.OK).entity(update).build();
    }

    @PUT
    @Path("/price/{price}")
        public Response updatePrice(@PathParam("price") int id, int price){
                Product updatePrice = service.updateProductPrice(id, price);
                if(updatePrice == null){
                    return Response.status(Response.Status.NOT_FOUND).entity("Product not found for ID: " + id ).build();
                }
                return Response.status(Response.Status.OK).entity(updatePrice).build();
        }
        @DELETE
        @Path("/{id}")
    public Response deleteProduct(@PathParam("id")int id){
        boolean deleted = service.deleteProduct(id);
        if(!deleted){
            return Response.status(Response.Status.NOT_FOUND).entity("Product not found for ID: " + id ).build();
        }
        return Response.noContent().build();
        }

}






 

