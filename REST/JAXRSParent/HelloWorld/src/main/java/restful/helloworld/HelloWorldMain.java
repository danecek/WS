package restful.helloworld;

import java.net.URISyntaxException;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.server.ResourceConfig;
import restful.tools.Tools;

public class HelloWorldMain {

    public static void main(String[] args) throws URISyntaxException {
        Tools.startJdkHttpServer(new ResourceConfig(MyResource.class));
        WebTarget myResourceTarget = Tools.myAppTarget().path("myresource");
        String responseEntity = myResourceTarget.request().get(String.class);
        System.out.println(responseEntity);
    }
}
