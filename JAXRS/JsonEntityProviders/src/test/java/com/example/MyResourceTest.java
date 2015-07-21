package com.example;

import com.sun.net.httpserver.HttpServer;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();
        target = c.target(Main.uriBuilder);
    }

    @After
    public void shutDown() {
        server.stop(1);
    }

    @Test
    public void testGet() {
        MyBean myBean = target.path("resource").request(MediaType.APPLICATION_JSON_TYPE).get(MyBean.class);
        System.out.println(myBean);
        assertEquals(MyResource.MY_BEAN, myBean);
    }
}
