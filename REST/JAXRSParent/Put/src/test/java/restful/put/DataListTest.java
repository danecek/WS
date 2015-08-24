package restful.put;

import com.sun.net.httpserver.HttpServer;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import org.glassfish.jersey.server.ResourceConfig;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static restful.tools.Tools.*;
import static org.junit.Assert.assertEquals;

public class DataListTest {

    private HttpServer server;

    @Before
    public void setUp() throws Exception {
        server = startJdkHttpServer(new ResourceConfig(DataList.class));
    }

    @After
    public void shutDown() {
        server.stop(1);
    }

    @Test
    public void test() {
        int responseMsg = myAppTarget().path("datalist").request().put(Entity.text("1.1.2015"), Integer.class);
        assertEquals(1, responseMsg);
    }
}
