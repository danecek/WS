package com.example;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLConnection;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyResourceTest {

    private HttpServer server;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();

    }

    @After
    public void shutDown() {
        server.stop(1);
    }

    @Test(expected = javax.ws.rs.NotAuthorizedException.class)
    public void test() throws MalformedURLException, IOException {
        Client c = ClientBuilder.newClient();
        WebTarget target = c.target(Main.uriBuilder).path("myresource");
        System.out.println(target);
        // String responseEntity
        Invocation.Builder ib = target.request();
        String response = ib.get(String.class);
        System.out.println(response);
    }
}
