/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author danecek
 */
public class Client {

    public static void main(String[] args) {
        javax.ws.rs.client.Client c = ClientBuilder.newClient();
        WebTarget target = c.target(Main.uriBuilder).path("resource");
        c.register(null)
        String myBeanString = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        System.out.println(myBeanString);
        MyBean myBean = target.request(MediaType.APPLICATION_JSON_TYPE).get(MyBean.class);
        System.out.println(myBean);
    }
}
