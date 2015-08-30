package restful.jettyserver;

import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;

/**
 * Main class.
 *
 */
public class JettyServerMain {

    public static UriBuilder restAppUriBuilder = UriBuilder.fromUri("http:").host("localhost").port(9998);
// path is neglected by jetty !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    public static void main(String[] args) throws IOException, Exception {
        ResourceConfig config = new ResourceConfig(MyResource.class);
        Server server = JettyHttpContainerFactory.createServer(restAppUriBuilder.build(), config);
        try {
            Client client = ClientBuilder.newClient();
            client.register(new LoggingFilter());
            WebTarget restAppTarget = client.target(restAppUriBuilder);
            WebTarget collectionTarget = restAppTarget.path("myresource");
            System.out.println(collectionTarget.request().get(String.class));
        } finally {
            server.stop();
        }

    }
}
