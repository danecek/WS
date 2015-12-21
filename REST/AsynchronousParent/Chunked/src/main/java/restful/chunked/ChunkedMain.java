/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.chunked;

import com.sun.net.httpserver.HttpServer;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ChunkedInput;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import restful.tools.Tools;

/**
 *
 * @author danecek
 */
public class ChunkedMain {

    public static void main(String[] args) {
        ResourceConfig rc = new ResourceConfig(ChunkedResource.class);
        HttpServer server = Tools.startJdkHttpServer(rc);
        try {
            Client client = ClientBuilder.newClient();
            client.register(new LoggingFilter());
            WebTarget restAppTarget = client.target(Tools.restAppUriBuilder);
            final Response response = restAppTarget.path("chunkedresource").request().get();
            final ChunkedInput<String> chunkedInput
                    = response.readEntity(new GenericType<ChunkedInput<String>>() {
                    });
            String chunk;
            while ((chunk = chunkedInput.read()) != null) {
                System.out.println("Next chunk received: " + chunk);
            }
        } finally {
            server.stop(1);
        }

    }
}
