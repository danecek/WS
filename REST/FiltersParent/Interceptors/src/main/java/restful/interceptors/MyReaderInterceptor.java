/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.interceptors;

import java.io.IOException;
import java.util.zip.GZIPInputStream;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

@Provider
public class MyReaderInterceptor implements ReaderInterceptor {
    
    @Override
    public Object aroundReadFrom(ReaderInterceptorContext ric) throws IOException, WebApplicationException {
        ric.setInputStream(new GZIPInputStream(ric.getInputStream()));
        System.out.println("aroundReadFrom before procede");
        Object result = ric.proceed();
        System.out.println("aroundReadFrom after procede");
        return result;
    }
    
}
