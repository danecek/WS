package restful.containerrequestfilter;

import com.sun.net.httpserver.HttpServer;
import java.net.URISyntaxException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import restful.tools.Tools;

public class ContainerRequestFilterMain {

    //  static UriBuilder uriBuilder = UriBuilder.fromUri("http:").host("localhost").port(9998).path("myapp");
    public static void main(String[] args) throws URISyntaxException {

        ResourceConfig rc = new ResourceConfig(AuthorizationRequestFilter.class, ProtectedResource.class);
        //       rc.property(ServerProperties.TRACING, "ALL");
        HttpServer server = Tools.startJdkHttpServer(rc);
        try {
            Client client = ClientBuilder.newClient();
            client.register(new LoggingFilter());
            WebTarget restAppTarget = client.target(Tools.restAppUriBuilder);
            Response resp = restAppTarget.path("protectedresource").request().get();
            System.out.println(resp.readEntity(String.class));
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            server.stop(1);
        }
    }
}
