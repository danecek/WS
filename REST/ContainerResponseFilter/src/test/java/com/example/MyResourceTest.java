package com.example;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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

    @Test
    public void test() throws MalformedURLException, IOException {
        URLConnection c = Main.uriBuilder.path("myresource").build().toURL().openConnection();
     //   URL url = new URL("http://localhost:9998/myapp/myresource");
        //  URLConnection c = url.openConnection();
        String response = c.getHeaderField("X-powered-by");
        assertEquals("Jersey :-)", response);
    }
}
