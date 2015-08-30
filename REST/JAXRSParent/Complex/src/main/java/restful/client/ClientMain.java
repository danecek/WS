/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.client;

//import com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe;
import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response;
import restful.rsservice.MyBean;
import org.glassfish.jersey.filter.LoggingFilter;

/**
 *
 * @author danecek
 */
public class ClientMain {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        // client.register(new MyReaderInterceptor());
        client.register(new LoggingFilter());
        WebTarget target = client.target("http://localhost:9998").path("resource");

//        Form form = new Form();
//        form.param("x", "foo");
//        form.param("y", "bar");
        //  MyJAXBBean bean
        Response result = target.request(MediaType.APPLICATION_XML)
                .get();
        if (result.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) // System.out.println(result.getEntity()); 
        {
            List<MyBean> beanList = result.readEntity(new GenericType<List<MyBean>>() {
            });
            System.out.println(beanList);
            // System.out.println(result.readEntity(MyBean.class));
        } else {
            System.out.println(result.getStatusInfo());
        }
    }

}
