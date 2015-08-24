package com.example;

import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import javax.ws.rs.core.UriBuilder;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;

/**
 * Main class.
 *
 */
public class Main {

    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/myapp/";

    public static void main(String[] args) throws IOException {
        URI baseUri = UriBuilder.fromUri(BASE_URI)
                .port(9998).build();
        ResourceConfig config
                = new ResourceConfig(MyResource.class);
        Server server = JettyHttpContainerFactory
                .createServer(baseUri, config);
        System.in.read();
      //  server.shutdown();
    }
}
