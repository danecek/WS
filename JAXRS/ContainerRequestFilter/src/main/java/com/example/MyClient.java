/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.IOException;
import java.net.MalformedURLException;
import javax.ws.rs.client.*;

/**
 *
 * @author danecek
 */
public class MyClient {

    public static void main(String[] args) throws MalformedURLException, IOException {

        Client c = ClientBuilder.newClient();
        WebTarget target = c.target(Main.uriBuilder).path("myresource");
        System.out.println(target);
        // String responseEntity
        Invocation.Builder ib = target.request();
        String response = ib.get(String.class);
        System.out.println(response);
    }
}
