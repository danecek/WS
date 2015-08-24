/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.xmlentityproviders;

import com.sun.net.httpserver.HttpServer;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import restful.tools.Tools;

/**
 *
 * @author danecek
 */
public class EntityProvidersMain {

    public static void main(String[] args) {
        HttpServer server = Tools.startJdkHttpServer(new ResourceConfig(EntityProvidersResource.class));
        try {
            Client c = ClientBuilder.newClient();
            c.register(new LoggingFilter());
            c.register(MyBeanMessageBodyReader.class);
            MyBean responseEntity = c.target(Tools.restAppUriBuilder).path("resource")
                    .request(MediaType.APPLICATION_XML_TYPE).get(MyBean.class);
            System.out.println(responseEntity);
        } finally {
            server.stop(1);
        }
    }
}
