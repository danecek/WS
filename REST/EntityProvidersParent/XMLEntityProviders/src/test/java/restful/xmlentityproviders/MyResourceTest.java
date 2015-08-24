package restful.xmlentityproviders;

import restful.xmlentityproviders.MyBean;
import restful.xmlentityproviders.EntityProvidersResource;
import restful.xmlentityproviders.MyBeanMessageBodyReader;
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
        server = Tools.startJdkHttpServer(new ResourceConfig(EntityProvidersResource.class));
        // create the client
        Client c = ClientBuilder.newClient();
        c.register(MyBeanMessageBodyReader.class);
        target = c.target(Tools.restAppUriBuilder);
    }

    @After
    public void x() {
        server.stop(1);
    }

    @Test
    public void testGetIt() {
        MyBean responseMsg = target.path("resource").request().get(MyBean.class);
        assertEquals(EntityProvidersResource.MY_BEAN, responseMsg);
    }
}
