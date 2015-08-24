package restful.put;

import java.net.URISyntaxException;
import java.util.Date;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.server.ResourceConfig;
import static restful.tools.Tools.*;

public class PutMain {

    public static void main(String[] args) throws URISyntaxException {
        startJdkHttpServer(new ResourceConfig(DataList.class));
        WebTarget dataListTarget = myAppTarget().path("datalist");
        int responseEntity = dataListTarget.request().put(Entity.text(new Date().toString()), Integer.class);
        System.out.println(responseEntity);
    }

}
