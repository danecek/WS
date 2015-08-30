package restful.containerresponsefilter;

import java.io.IOException;
import javax.ws.rs.container.*;

public class PoweredByResponseFilter
        implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext,
            ContainerResponseContext responseContext)
            throws IOException {
        responseContext.getHeaders().add("X-Powered-By",
                "Jersey :-)");
    }
}
