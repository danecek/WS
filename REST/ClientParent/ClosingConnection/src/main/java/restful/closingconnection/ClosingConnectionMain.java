/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.closingconnection;

import com.google.common.io.CharStreams;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.Reader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.server.ResourceConfig;
import restful.tools.Tools;

/**
 *
 * @author danecek
 */
public class ClosingConnectionMain {

    public static void main(String[] args) throws IOException {
        UriBuilder restAppUriBuilder = UriBuilder.fromUri("http:").host("localhost").port(9998).path("restapp");
        HttpServer server
                = Tools.startJdkHttpServer(restAppUriBuilder,
                        new ResourceConfig(ClosingConnectionResource.class));
        try {
            Client c = ClientBuilder.newClient();
            //   c.register(new LoggingFilter(Logger.getAnonymousLogger(), true));
            WebTarget fileResourceTarget = c.target(restAppUriBuilder).path("filesource");
            Response resp = fileResourceTarget.request().get();
            String text = CharStreams.toString(resp.readEntity(Reader.class));
            resp.close();
            System.out.println(text);
        } finally {
            server.stop(1);
        }
    }
}
