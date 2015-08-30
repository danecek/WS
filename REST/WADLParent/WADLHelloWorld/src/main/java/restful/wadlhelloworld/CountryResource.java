/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.wadlhelloworld;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author danecek
 */
@Path("resource")
public class CountryResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
}
