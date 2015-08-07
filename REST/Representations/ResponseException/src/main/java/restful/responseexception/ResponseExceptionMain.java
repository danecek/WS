/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.responseexception;

import com.sun.net.httpserver.HttpServer;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import restful.tools.Tools;

/**
 *
 * @author danecek
 */
public class ResponseExceptionMain {

    static class MyApplication extends ResourceConfig {

        public MyApplication() {
            super(ResponseExceptionResource.class);
            //       register(new LoggingFilter(Logger.getAnonymousLogger(), true));
        }

    }

    public static void main(String[] args) throws HeadlessException, IOException {

        HttpServer server = Tools.startJdkHttpServer(new MyApplication());
        try {
            WebTarget collectionTarget = Tools.myAppTarget().path("items");
            String key = "key";
            String item = collectionTarget.path("key").request().get(String.class);
            System.out.printf("items[%s]= %s\n", key, item);
            collectionTarget.path("xxx").request().get(String.class);
        } finally {
            server.stop(1);
        }
    }
}
