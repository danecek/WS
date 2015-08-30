/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.crud;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response;

public class CRUDSubresource {

    private final CRUDResource resource;

    public CRUDSubresource(CRUDResource resource) {
        this.resource = resource;
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Person getXml(@PathParam("id") int id) {
        return resource.data.get(id);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_XML)
    public Response delete(@PathParam("id") int id) {
        if (resource.data.containsKey(id)) {
            return Response.ok(resource.data.remove(id)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putXml(Person person, @Context UriInfo uriInfo) {
        if (!resource.data.containsKey(person.id)) {
            resource.data.put(person.id, person);
            return Response.created(uriInfo.getRequestUri()).build();
        }
        return Response.ok().build();
    }
}
