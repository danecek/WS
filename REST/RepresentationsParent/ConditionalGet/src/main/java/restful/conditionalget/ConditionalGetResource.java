package restful.conditionalget;

import com.google.common.io.ByteStreams;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.URLDataSource;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;

import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

@Path("resources")
public class ConditionalGetResource {

    @GET
    @Path("{resourceName}")
    public Response getResource(@Context Request request,
            @PathParam("resourceName") String resourceName) {
        URL rurl = getClass().getResource("/" + resourceName);
        if (rurl == null) {
            throw new NotFoundException();
        }
        URLDataSource ds = new URLDataSource(rurl);
        EntityTag resourceTag = computeEntityTag(ds);
        Response.ResponseBuilder rb
                = request.evaluatePreconditions(resourceTag);
        if (rb != null) {
            return rb.build();
        }
        return Response.ok(ds).tag(resourceTag).build();
    }

    private EntityTag computeEntityTag(URLDataSource ds) {
        try {
            byte[] bytesOfStream = ByteStreams.toByteArray(ds.getInputStream());
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] theDigest = md.digest(bytesOfStream);
            String dsn = Arrays.toString(theDigest);
            return new EntityTag(dsn);
        } catch (IOException | NoSuchAlgorithmException ex) {
            Logger.getLogger(ConditionalGetResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
