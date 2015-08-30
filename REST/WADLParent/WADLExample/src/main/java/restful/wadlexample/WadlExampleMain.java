/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.wadlexample;

import com.google.common.io.CharStreams;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import restful.crud.CRUDMain;
import restful.tools.Tools;

public class WadlExampleMain {

    public static void main(String[] args) throws MalformedURLException, IOException {
        HttpServer server = CRUDMain.startServer();
        try {
            URL url = Tools.restAppUriBuilder.path("application.wadl").
                    //       queryParam("detail", true).
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
