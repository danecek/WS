/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.interceptors;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

@Provider
public class MyWriterInterceptor implements WriterInterceptor {
    
    @Override
    public void aroundWriteTo(WriterInterceptorContext wic) throws IOException, WebApplicationException {
        wic.setOutputStream(new GZIPOutputStream(wic.getOutputStream()));
        System.out.println("aroundWriteTo before procede");
        wic.proceed();
        System.out.println("aroundWriteTo after procede");
    }
    
}
