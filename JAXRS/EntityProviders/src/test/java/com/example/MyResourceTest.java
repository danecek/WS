package com.example;

import com.sun.net.httpserver.HttpServer;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

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
        c.register(MyBeanMessageBodyReader.class);
        target = c.target(Main.uriBuilder);
    }

    @After
    public void x() {
        server.stop(1);
    }

    @Test
    public void testGetIt() {
        MyBean responseMsg = target.path("resource").request().get(MyBean.class);
        assertEquals(MyResource.MY_BEAN, responseMsg);
    }
}
