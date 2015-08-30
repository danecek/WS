package com.example;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.glassfish.jersey.filter.LoggingFilter;
import restful.tools.Tools;

public class GrizzlyServerMain {

    public static void main(String[] args) throws IOException {
        final ResourceConfig rc = Tools.resConf(MyResource.class);
        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(Tools.restAppUriBuilder.build(), rc);
        try {
            System.out.println(String.format("Jersey app started with WADL available at "
                    + "%s/application.wadl\n", Tools.restAppUriBuilder));
            Client client = ClientBuilder.newClient();
            client.register(new LoggingFilter());
            WebTarget restAppTarget = client.target(Tools.restAppUriBuilder);
            WebTarget collectionTarget = restAppTarget.path("myresource");
            System.out.println(collectionTarget.request().get(String.class));
        } finally {
            server.shutdown();
        }
    }
}
