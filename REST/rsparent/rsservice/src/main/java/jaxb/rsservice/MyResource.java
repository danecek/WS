/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.rsservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("resource")
@Produces(MediaType.APPLICATION_JSON)//"text/xml")
public class MyResource {


    @GET
    public MyBean hello() {
        return new MyBean(2);
    }

}
