/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author danecek
 */
public class MyClient {

    public static void main(String[] args) {
        Client c = ClientBuilder.newClient();
        c.register(MyBeanMessageBodyReader.class);
        MyBean responseEntity = c.target(Main.uriBuilder).path("resource")
                .request(MediaType.APPLICATION_XML_TYPE).get(MyBean.class);
        System.out.println(responseEntity);
    }
}
