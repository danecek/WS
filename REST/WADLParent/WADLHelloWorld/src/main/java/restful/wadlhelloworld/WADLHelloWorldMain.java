/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.wadlhelloworld;

import com.google.common.io.CharStreams;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.glassfish.jersey.server.ResourceConfig;
import restful.tools.Tools;

/**
 *
 * @author danecek
 */
public class WADLHelloWorldMain {

    public static void main(String[] args) throws MalformedURLException, IOException {
        ResourceConfig rc = new ResourceConfig(CountryResource.class);
        HttpServer server = Tools.startJdkHttpServer(rc);
        try {
            URL url = Tools.restAppUriBuilder.path("application.wadl").
                   // queryParam("detail", true).
                    build().toURL();
            URLConnection c = url.openConnection();
            InputStreamReader inr = new InputStreamReader(c.getInputStream());
            String text = CharStreams.toString(inr);
            System.out.println(text);
        } finally {
            server.stop(1);
        }
    }
}
