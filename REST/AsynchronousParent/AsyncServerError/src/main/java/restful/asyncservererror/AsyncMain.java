/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.asyncservererror;

import com.sun.net.httpserver.HttpServer;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import restful.tools.Tools;

/**
 *
 * @author danecek
 */
public class AsyncMain {

    public static void main(String[] args) throws InterruptedException {
        ResourceConfig rc = new ResourceConfig(AsyncResource.class);
        HttpServer server = Tools.startJdkHttpServer(rc);
        Thread.sleep(5000);
        try {
            Client client = ClientBuilder.newClient();
            client.register(new LoggingFilter());
            WebTarget restAppTarget = client.target(Tools.restAppUriBuilder);
            Response resp = restAppTarget.path("asyncresource").request().get();
            System.out.println(resp.readEntity(String.class));
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            server.stop(1);
        }

    }
}
