/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.rsservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("resource")
@Produces(MediaType.APPLICATION_XML)//"text/xml")
public class MyResource {

    @GET
    public List<MyBean> hello() {
        List<MyBean> l = new ArrayList<>();
        Collections.addAll(l, new MyBean(2), new MyBean(3));
        return l;
    }

}
