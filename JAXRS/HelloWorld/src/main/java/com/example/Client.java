/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ws.rs.client.ClientBuilder;

/**
 *
 * @author danecek
 */
public class Client {

    public static void main(String[] args) {
        String responseEntity = ClientBuilder.newClient().target("http://localhost:8080/myapp").path("myresource")
                .request().get(String.class);
        System.out.println(responseEntity);
    }
}
