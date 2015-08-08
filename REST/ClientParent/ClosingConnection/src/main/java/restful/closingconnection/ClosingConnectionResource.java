/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.closingconnection;

import java.io.InputStreamReader;
import java.io.Reader;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author danecek
 */
@Path("filesource")
public class ClosingConnectionResource {

    @GET
    public Reader get() {
        return new InputStreamReader(getClass().getResourceAsStream("/file.txt"));
    }

}
