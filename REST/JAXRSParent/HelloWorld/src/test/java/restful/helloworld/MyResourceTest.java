package restful.helloworld;

import com.sun.net.httpserver.HttpServer;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.glassfish.jersey.server.ResourceConfig;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import restful.tools.Tools;

public class MyResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Tools.startJdkHttpServer(new ResourceConfig(MyResource.class));
        // create the client
        Client c = ClientBuilder.newClient();
        target = c.target(Tools.restAppUriBuilder);
    }

    @After
    public void shutDown() {
        server.stop(1);
    }

    @Test
    public void test() {
        String responseMsg = target.path("myresource").request().get(String.class);
        assertEquals("Hello", responseMsg);
    }
}
