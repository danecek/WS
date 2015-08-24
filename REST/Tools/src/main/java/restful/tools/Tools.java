package restful.tools;

import com.sun.net.httpserver.HttpServer;
import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import javax.ws.rs.core.*;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Tools {

    public static UriBuilder restAppUriBuilder = UriBuilder.fromUri("http:").host("localhost").port(9998).path("restapp");

    public static HttpServer startJdkHttpServer(UriBuilder uriBuilder, ResourceConfig config) {
        URI baseUri = uriBuilder.build();
        System.out.println(baseUri);
        return JdkHttpServerFactory.createHttpServer(baseUri, config);
    }

    public static HttpServer startJdkHttpServer(ResourceConfig config) {
        return startJdkHttpServer(restAppUriBuilder, config);
    }

    public static WebTarget myAppTarget() {
        Client c = ClientBuilder.newClient();
        //   c.register(new LoggingFilter(Logger.getAnonymousLogger(), true));
        WebTarget target = c.target(restAppUriBuilder);
        return target;
    }
}
