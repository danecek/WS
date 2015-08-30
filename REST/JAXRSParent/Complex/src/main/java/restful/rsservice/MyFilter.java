/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.rsservice;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author danecek
 */
@Provider
public class MyFilter implements ContainerRequestFilter {

    public void filter(ContainerRequestContext crc) throws IOException {
        System.out.println("ffffffffffffffffffffffffffffffffffffffffffff");
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
