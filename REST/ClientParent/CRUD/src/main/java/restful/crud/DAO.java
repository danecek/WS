/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.crud;

import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author danecek
 */
public class DAO {

    private final WebTarget collectionTarget;

    public DAO(WebTarget collectionTarget) {
        this.collectionTarget = collectionTarget;
    }

//    List<Person> readAll() {
//        return collectionTarget.request(MediaType.APPLICATION_XML).get(Persons.class).persons;
//    }

    List<Person> readAll2() {
        return collectionTarget.request(MediaType.APPLICATION_XML).get(new GenericType<List<Person>>() {
        });
    }

    void create(Person p) throws CRUDException {
        WebTarget personTarget = collectionTarget.path(p.id.toString());
        Response r = personTarget.request(MediaType.APPLICATION_XML).put(Entity.xml(p));
        if (r.getStatus() != Response.Status.CREATED.getStatusCode()) {
            throw new CRUDException(String.format("id %d already exists", p.id));
        }
    }

    void update(Person p) throws CRUDException {
        WebTarget personTarget = collectionTarget.path(p.id.toString());
        Response r = personTarget.request(MediaType.APPLICATION_XML).put(Entity.xml(p));
        if (r.getStatusInfo().getFamily() != Response.Status.Family.SUCCESSFUL) {
            throw new CRUDException(r);
        }
    }

    Person read(Integer id) throws CRUDException {
        WebTarget personTarget = collectionTarget.path(id.toString());
        Response r = personTarget.request(MediaType.APPLICATION_XML).get();
        if (r.getStatusInfo().getFamily() != Response.Status.Family.SUCCESSFUL) {
            throw new CRUDException(r);
        }
        return r.readEntity(Person.class);
    }

    Person delete(Integer id) throws CRUDException {
        WebTarget personTarget = collectionTarget.path(id.toString());
        Response r = personTarget.request(MediaType.APPLICATION_XML).delete();
        if (r.getStatusInfo().getFamily() != Response.Status.Family.SUCCESSFUL) {
            throw new CRUDException(r);
        }
        return r.readEntity(Person.class);
    }

}
