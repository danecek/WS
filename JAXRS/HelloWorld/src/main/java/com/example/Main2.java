/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.net.URI;
import java.net.URISyntaxException;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author danecek
 */
public class Main2 {

    public static void main(String[] args) throws URISyntaxException {
      //  URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
        ResourceConfig config = new ResourceConfig(MyResource.class);
        JdkHttpServerFactory.createHttpServer(URI.create(Main.BASE_URI), config);

//        ResourceConfig rc = new ResourceConfig(MyResource.class);//, MyHandler.class);
//        Object http = JdkHttpServerFactory.createHttpServer(new URI(Main.BASE_URI), rc);
//        HttpHandler endpoint = RuntimeDelegate.getInstance()
//                .createEndpoint(new MyApplication(), MyHandler.class);
//        endpoint.start();
    }
}
