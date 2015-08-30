/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.logging;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("loggingresource")
public class LoggingResource {

    @GET
    public String get() {
        return "sync";
    }

}
