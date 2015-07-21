/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ws.rs.client.*;

/**
 *
 * @author danecek
 */
public class MyClient {
    
    public static void main(String[] args) {
        Client c = ClientBuilder.newClient();
        WebTarget target = c.target(Main.uriBuilder).path("myresource");
        String responseEntity = target.request().get(String.class);
        System.out.println(responseEntity);
    }
}
