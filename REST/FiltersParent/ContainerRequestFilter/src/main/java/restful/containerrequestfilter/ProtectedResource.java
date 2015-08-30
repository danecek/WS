package restful.containerrequestfilter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

@Path("protectedresource")
public class ProtectedResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@Context UriInfo ui) {
        return "Got it!";
    }
}
