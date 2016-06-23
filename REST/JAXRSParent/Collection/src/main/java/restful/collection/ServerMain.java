/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.collection;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.filter.LoggingFilter;
import restful.tools.Tools;

/**
 *
 * @author danecek
 */
public class ServerMain {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        HttpServer server = Tools.startJdkHttpServer(Tools.resConf(MyResource.class));
        try {
            Client client = ClientBuilder.newClient();
            client.register(new LoggingFilter());
            WebTarget resourceTarget = client.target(Tools.restAppUriBuilder).path("resource");
            Response result = resourceTarget.request(MediaType.APPLICATION_XML)
                    .get();
            if (result.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
                List<MyBean> beanList = result.readEntity(new GenericType<List<MyBean>>() {
                });
                System.out.println(beanList);
            } else {
                System.out.println(result.getStatusInfo());
            }
        } finally {
            server.stop(1);
        }

    }

}
