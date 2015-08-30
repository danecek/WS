/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.containerresponsefilter;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.glassfish.jersey.server.ResourceConfig;
import restful.tools.Tools;

/**
 *
 * @author danecek
 */
public class ContainerResponseFilterMain {

    public static void main(String[] args) throws MalformedURLException, IOException {
        ResourceConfig rc = new ResourceConfig(PoweredByResponseFilter.class, MyResource.class);
        HttpServer server = Tools.startJdkHttpServer(rc);
        try {
            URL url = Tools.restAppUriBuilder.build().toURL();
            URLConnection c = url.openConnection();
            System.out.printf("X-powered-by: %s\n", c.getHeaderField("X-powered-by"));
        } finally {
            server.stop(1);
        }

    }
}
