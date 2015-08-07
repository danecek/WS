/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.imagedownload;

import java.io.File;
import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("imagedownload")
public class ImageDownloadResource {

    @GET
    @Path("{file}")
    @Produces(MediaType.WILDCARD)
    public Response getImage(
            @PathParam("file") String image) {
        File f = new File(image);
        if (!f.exists()) {
            throw new WebApplicationException(404);
        }
        String mt = new MimetypesFileTypeMap().getContentType(f);
        System.out.println(mt);
        return Response.ok(f, mt).build();
    }
}
