/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.rsclient;

//import com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jaxb.rsservice.MyBean;
import org.glassfish.jersey.filter.LoggingFilter;

/**
 *
 * @author danecek
 */
public class ClientMain {

    public static void main(String[] args) {
//        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
//        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
//        //    com.sun.xml.ws.transport.http.client

        Client client = ClientBuilder.newClient();
  
        client.register(new LoggingFilter(Logger.getAnonymousLogger(), true));
        //client.
      //  client.register(new MyInterceptor());
        WebTarget target = client.target("https://localhost:4463").path("resource");
//        Form form = new Form();
//        form.param("x", "foo");
//        form.param("y", "bar");
        //  MyJAXBBean bean
        Response result = target.request(MediaType.APPLICATION_JSON)
                .get();
        System.out.println(result.readEntity(MyBean.class));
    }

}
