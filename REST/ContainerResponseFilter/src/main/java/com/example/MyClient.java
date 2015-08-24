/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author danecek
 */
public class MyClient {

    public static void main(String[] args) throws MalformedURLException, IOException {

         // URLConnection c = Main.uriBuilder.path("myresource").build().toURL().openConnection();
        URL url = Main.uriBuilder.path("myresource").build().toURL();
        URLConnection c = url.openConnection();
        System.out.println(c.getHeaderField("X-powered-by"));

//        Client c = ClientBuilder.newClient();
//        WebTarget target = c.target(Main.uriBuilder).path("myresource");
//        System.out.println(target);
//        String responseEntity = target.request().get(String.class);
//        System.out.println(responseEntity);
    }
}
