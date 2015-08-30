/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.crud;

import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.*;

@Path("crud")
@Singleton
public final class CRUDResource {

    Map<Integer, Person> data = new HashMap<>();

    void put(Person p) {
        data.put(p.id, p);
    }

    public CRUDResource() {
        put(new Person(1, "John"));
        put(new Person(2, "Marry"));
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Persons persons() {
        return new Persons(data.values());
    }

    @Path("{id}")
    public CRUDSubresource sr() {
        return new CRUDSubresource(this);
    }

}
