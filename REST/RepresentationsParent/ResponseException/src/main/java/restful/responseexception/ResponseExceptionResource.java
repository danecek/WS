/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.responseexception;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Path("items")
public class ResponseExceptionResource {

    private static final Map<String, String> ITEMS;

    static {
        ITEMS = new HashMap<>();
        ITEMS.put("key", "vaue");
    }

    void find(String itemid) {
        String i = ITEMS.get(itemid);
        if (i == null) {
            throw new NotFoundException(
                    "Item, " + itemid + ", is not found");
        }
        throw new WebApplicationException(Response.ok(i).build());
    }

    @Path("{itemid}")
    @GET
    public void getItem(@PathParam("itemid") String itemid) {
        find(itemid);
    }
}
