/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.tools;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.*;

/**
 *
 * @author danecek
 */
@Provider
public class MyExceptionMapper implements ExceptionMapper<Exception> {

    public MyExceptionMapper() {
        System.out.println(this);
    }

    @Override
    public Response toResponse(Exception e) {
        return Response.ok(e).build();
    }

}
