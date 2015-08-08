/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.queryparams;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author danecek
 */
@Path("greetingresource")
public class QueryParamsResource {

    @GET
    public String greeting(@QueryParam("name") String name) {
        return String.format("Hello %s!", name);
    }

}
