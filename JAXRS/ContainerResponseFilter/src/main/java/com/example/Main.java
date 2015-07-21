package com.example;

import com.sun.net.httpserver.HttpServer;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.core.*;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Main {

    static UriBuilder uriBuilder = UriBuilder.fromUri("http:").host("localhost").port(9998).path("myapp");

    public static void main(String[] args) throws URISyntaxException {
        startServer();
    }

    static HttpServer startServer() {
        URI baseUri = uriBuilder.build();
        System.out.println(baseUri);
        ResourceConfig config = new ResourceConfig(MyResource.class, PoweredByResponseFilter.class);
        return JdkHttpServerFactory.createHttpServer(baseUri, config);
    }
}
