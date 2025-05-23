package org.example.productservice;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.grizzly.http.server.HttpServer;

import java.net.URI;

public class Main {
    public static final String BASE_URI = "http://0.0.0.0:8080/api/";

    public static HttpServer startserver(){
        final ResourceConfig config = new ResourceConfig().packages("org.example.productservice.controller");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), config);
    };

    public static void main(String[] args) {


        try{
            final HttpServer server = startserver();
            System.out.println("Server started at " + BASE_URI);
            Thread.currentThread().join();
        }catch(Exception e){
            System.err.println("❌ ERROR: " + e.getMessage());
            e.printStackTrace();
        }

    }



}