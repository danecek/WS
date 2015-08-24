package restful.helloworld;

import java.net.URISyntaxException;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.server.ResourceConfig;
import static restful.tools.Tools.*;

public class HelloWorldMain {

    public static void main(String[] args) throws URISyntaxException {
        startJdkHttpServer(new ResourceConfig(MyResource.class));
        WebTarget myResourceTarget = myAppTarget().path("myresource");
        String responseEntity = myResourceTarget.request().get(String.class);
        System.out.println(responseEntity);
    }
}
