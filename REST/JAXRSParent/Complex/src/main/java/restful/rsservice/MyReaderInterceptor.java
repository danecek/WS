/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.rsservice;

import java.io.IOException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

@Provider
public class MyReaderInterceptor implements ReaderInterceptor {

    public Object aroundReadFrom(ReaderInterceptorContext ric) throws IOException, WebApplicationException {
        System.out.println("aroundReadFrom before procede");
        Object result = ric.proceed();
        System.out.println("aroundReadFrom after procede");
        return result;
        //oose Tools | Templates.
    }

}
