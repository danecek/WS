/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.clienthelloworld;

import com.sun.net.httpserver.HttpServer;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.server.ResourceConfig;
import restful.tools.Tools;

/**
 *
 * @author danecek
 */
public class ClientHelloWorldMain {

    public static void main(String[] args) {
        UriBuilder restAppUriBuilder = UriBuilder.fromUri("http:").host("localhost").port(9998).path("restapp");
        HttpServer server
                = Tools.startJdkHttpServer(restAppUriBuilder,
                        new ResourceConfig(ClientHelloWorldResource.class));
        try {

            Client c = ClientBuilder.newClient();
            //   c.register(new LoggingFilter(Logger.getAnonymousLogger(), true));
            //      WebTarget helloResourceTarget = c.target(restAppUriBuilder).path("helloresource");

            WebTarget helloResourceTarget = c.target("http://localhost:9998/restapp/helloresource");
            System.out.println(helloResourceTarget.request().get(String.class));

        } finally {
            server.stop(1);
        }
    }
}
