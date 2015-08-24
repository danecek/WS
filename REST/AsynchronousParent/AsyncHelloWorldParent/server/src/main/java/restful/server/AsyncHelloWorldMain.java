/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.server;

import com.sun.net.httpserver.HttpServer;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import restful.tools.Tools;

/**
 *
 * @author danecek
 */
public class AsyncHelloWorldMain {

    public static void main(String[] args) throws InterruptedException {
        ResourceConfig rc = new ResourceConfig(AsyncHelloWorldResource.class);
        rc.property(ServerProperties.TRACING, "ALL");
        HttpServer server = Tools.startJdkHttpServer(rc);
    }
}
