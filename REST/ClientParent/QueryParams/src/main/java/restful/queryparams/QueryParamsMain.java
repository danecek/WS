/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.queryparams;

import com.sun.net.httpserver.HttpServer;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import restful.tools.Tools;

/**
 *
 * @author danecek
 */
public class QueryParamsMain {

    public static void main(String[] args) {
        HttpServer server
                = Tools.startJdkHttpServer(new ResourceConfig(QueryParamsResource.class));
        try {
            Client c = ClientBuilder.newClient();
            WebTarget greetingResourceTarget = c.target(Tools.restAppUriBuilder).path("greetingresource");
            greetingResourceTarget.register(new LoggingFilter());
            WebTarget queryTarget = greetingResourceTarget.queryParam("name", "Jerry");
            System.out.println(queryTarget.request().get(String.class));

        } finally {
            server.stop(1);
        }
    }
}
