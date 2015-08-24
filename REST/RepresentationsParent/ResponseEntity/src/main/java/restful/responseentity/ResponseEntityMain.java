/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.responseentity;

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
public class ResponseEntityMain {

    static class MyApplication extends ResourceConfig {

        public MyApplication() {
            super(ResponseEntityResource.class);
            register(new LoggingFilter(Logger.getAnonymousLogger(), true));
        }

    }

    public static void main(String[] args) throws HeadlessException, IOException {

        HttpServer server = Tools.startJdkHttpServer(new MyApplication());
        try {
            WebTarget collectionTarget = Tools.myAppTarget().path("collection");
            Response r = collectionTarget.request().post(Entity.text("asdfg"));//Entity.text("xxx"));
            System.out.println("response:" + Arrays.toString(r.readEntity(byte[].class)));
            Response r2 = collectionTarget.path(0 + "").request().get();
            System.out.println(r2.readEntity(String.class));
        } finally {
            server.stop(1);
        }
    }
}
