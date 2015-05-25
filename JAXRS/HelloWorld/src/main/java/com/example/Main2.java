/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ws.rs.ext.RuntimeDelegate;
import org.glassfish.grizzly.http.server.HttpHandler;

/**
 *
 * @author danecek
 */
public class Main2 {

    public static void main(String[] args) {
        http  =JdkHttpServerFactory.createHttpServer();
        HttpHandler endpoint = RuntimeDelegate.getInstance()
                .createEndpoint(new MyApplication(), MyHandler.class);
        endpoint.start();
    }
}
