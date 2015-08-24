package restful.jsonentityprovider;

import com.sun.net.httpserver.HttpServer;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import restful.tools.Tools;
import static org.junit.Assert.assertEquals;

public class JsonEntityProviderResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = JsonEntityProviderMain.startServer();
        // create the client
        Client c = ClientBuilder.newClient();
        target = c.target(Tools.restAppUriBuilder);
    }

    @After
    public void shutDown() {
        server.stop(1);
    }

    @Test
    public void testGet() {
        MyBean myBean = target.path("resource").request(MediaType.APPLICATION_JSON_TYPE).get(MyBean.class);
        System.out.println(myBean);
        assertEquals(JsonEntityProviderResource.MY_BEAN, myBean);
    }
}
