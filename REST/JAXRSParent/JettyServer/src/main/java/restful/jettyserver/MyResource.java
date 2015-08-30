package restful.jettyserver;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

@Path("myresource")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getIt(@Context UriInfo ui) {
        return "Got it!";
    }
}
