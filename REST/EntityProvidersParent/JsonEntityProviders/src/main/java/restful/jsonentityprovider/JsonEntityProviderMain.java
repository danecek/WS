package restful.jsonentityprovider;

import com.sun.net.httpserver.HttpServer;
import java.net.URISyntaxException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import javax.ws.rs.core.*;
import org.glassfish.jersey.server.ResourceConfig;
import restful.tools.Tools;

public class JsonEntityProviderMain {

    public static void main(String[] args) throws URISyntaxException {
        HttpServer server = startServer();
        try {
            javax.ws.rs.client.Client c = ClientBuilder.newClient();
            WebTarget target = c.target(Tools.restAppUriBuilder).path("resource");
            String myBeanString = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
            System.out.println(myBeanString);
            MyBean myBean = target.request(MediaType.APPLICATION_JSON_TYPE).get(MyBean.class);
            System.out.println(myBean);
        } finally {
            server.stop(1);
        }
    }

    static HttpServer startServer() {
        ResourceConfig config = new ResourceConfig(JsonEntityProviderResource.class);
        config.register(new MyBeanMessageBodyWriter());
        return Tools.startJdkHttpServer(config);
    }
}
