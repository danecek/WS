/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.clienthelloworld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author danecek
 */
@Path("helloresource")
public class ClientHelloWorldResource {
    
    @GET    
    public String get() {
        return "hello";
    }
    
}
