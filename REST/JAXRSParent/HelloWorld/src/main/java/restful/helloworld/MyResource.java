package restful.helloworld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("myresource")
public class MyResource {

    @GET
    public String sayHello() {
        return "Hello";
    }
}
