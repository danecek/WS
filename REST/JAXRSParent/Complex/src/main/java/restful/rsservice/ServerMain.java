/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.rsservice;

import java.io.IOException;
import java.net.URI;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.ssl.SSLEngineConfigurator;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author danecek
 */
public class ServerMain {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
        ResourceConfig config = new MyResourceConfig();
//        JdkHttpServerFactory.createHttpServer(baseUri, config);
//        SSLContext sslc = SSLContext.getDefault();// = new SSLContext();
//        SSLEngineConfigurator sc = new SSLEngineConfigurator(sslc);
        GrizzlyHttpServerFactory.createHttpServer(baseUri, config);//, true, sc, true);
        System.in.read();
    }

}
