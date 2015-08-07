/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.conditionalget;

import com.sun.net.httpserver.HttpServer;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.logging.Logger;
import javax.ws.rs.client.WebTarget;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import restful.tools.Tools;

/**
 *
 * @author danecek
 */
public class ConditionalGetMain {

    static class MyApplication extends ResourceConfig {

        public MyApplication() {
            super(ConditionalGetResource.class);
            register(new LoggingFilter(Logger.getAnonymousLogger(), true));
        }

    }

    public static void main(String[] args) throws HeadlessException, IOException {
        HttpServer server = Tools.startJdkHttpServer(new MyApplication());
        try {
            WebTarget collectionTarget = Tools.myAppTarget().path("resources");
            String resourceName = "file.txt";
            String resource = collectionTarget.path(resourceName).request().get(String.class);
            System.out.printf("Resource %s -> %s\n", resourceName, resource);
            resource = collectionTarget.path(resourceName).request().get(String.class);
            System.out.printf("Resource %s -> %s\n", resourceName, resource);
        } finally {
            server.stop(1);
        }
    }
}
