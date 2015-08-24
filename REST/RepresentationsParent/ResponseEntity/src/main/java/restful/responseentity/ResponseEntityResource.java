/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.responseentity;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Path("collection")
public class ResponseEntityResource {

    static List<String> data = new ArrayList<>();

    @POST
    public Response post(String content, @Context UriInfo uriInfo) {
        data.add(content);
        URI createdUri = UriBuilder.fromUri(uriInfo.getRequestUri()).path(data.size() + "").build();
        return Response.created(createdUri).entity(new int[]{(byte) data.size()}).build();

    }

    @GET
    @Path("{index}")
    public Response get(@PathParam("index") int index) {
        String elem = data.get(index);
        if (index >= data.size()) {
            throw new WebApplicationException("out of index range");
        }
        return Response.ok().entity(elem).build();
    }
}
