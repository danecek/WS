package restful.containerrequestfilter;

import java.io.IOException;
import javax.ws.rs.container.*;
import javax.ws.rs.core.*;

public class AuthorizationRequestFilter
        implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext)
            throws IOException {
        final SecurityContext securityContext
                = requestContext.getSecurityContext();
        if (securityContext == null
                || !securityContext.isUserInRole("privileged")) {
            requestContext.abortWith(Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("User cannot access the resource.")
                    .build());
        }
    }
}
