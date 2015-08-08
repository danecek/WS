/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.fluent;

import com.sun.net.httpserver.HttpServer;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import restful.tools.Tools;

/**
 *
 * @author danecek
 */
public class FluentMain {

    private static Response put(WebTarget greetingResource, String greeting) {
        Invocation.Builder ib = greetingResource.request();
        return ib.put(Entity.text(greeting));
    }

    public static void main(String[] args) {
        HttpServer server
                = Tools.startJdkHttpServer(new ResourceConfig(FluentResource.class));
        try {
            Client client = ClientBuilder.newClient();
            client.register(new LoggingFilter());
            UriBuilder restAppUriBuilder = UriBuilder.fromUri("http:").host("localhost").port(9998).path("restapp");
            WebTarget restAppResource = client.target(restAppUriBuilder);
            WebTarget greetingResource = restAppResource.path("greetingresource");
            WebTarget queriedGreetingRes = greetingResource.queryParam("name", "Jerry");
            Invocation.Builder invBuilder = queriedGreetingRes.request();
            Invocation inv = invBuilder.buildGet();
            Response resp = inv.invoke();
            String greeting = resp.readEntity(String.class);
            System.out.println(greeting);
                     
            int status = greetingResource.request().put(Entity.text("Hi")).getStatus();

            System.out.println(status);

            String grtFluently = ClientBuilder.newClient().
                    target(restAppUriBuilder).path("greetingresource").queryParam("name", "Tom").request().get(String.class);
            System.out.println(grtFluently);

        } finally {
            server.stop(1);
        }
    }
}
