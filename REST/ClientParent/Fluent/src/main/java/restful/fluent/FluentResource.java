/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.fluent;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author danecek
 */
@Path("greetingresource")
public class FluentResource {

    private static String greeting = "Hello";

    @GET
    public String getGreeting(@QueryParam("name") String name) {
        return String.format("%s %s!", greeting, name);
    }

    @PUT
    public Response putGreeting(String greeting) {
        FluentResource.greeting = greeting;
        return Response.ok().build();
    }

}
