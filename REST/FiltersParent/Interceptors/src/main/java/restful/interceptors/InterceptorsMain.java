package restful.interceptors;

import com.sun.net.httpserver.HttpServer;
import java.net.URISyntaxException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import restful.tools.Tools;

public class InterceptorsMain {

    public static void main(String[] args) throws URISyntaxException {

        ResourceConfig rc = new ResourceConfig(ProtectedResource.class,
                MyReaderInterceptor.class,
                MyWriterInterceptor.class);
        //       rc.property(ServerProperties.TRACING, "ALL");
        HttpServer server = Tools.startJdkHttpServer(rc);
        try {
            Client client = ClientBuilder.newClient();
            client.register(new LoggingFilter());
            client.register(MyReaderInterceptor.class);
            client.register(MyWriterInterceptor.class);
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
