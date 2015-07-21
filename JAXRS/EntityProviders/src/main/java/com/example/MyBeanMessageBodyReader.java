/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.ws.rs.*;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.*;
import java.lang.reflect.*;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.Unmarshaller;
//import org.eclipse.persistence.jaxb.*;

@Produces({"application/xml"})
@Provider
public class MyBeanMessageBodyReader implements
        MessageBodyReader<MyBean> {

    @Override
    public boolean isReadable(Class<?> type, Type genericType,
            Annotation[] annotations, javax.ws.rs.core.MediaType mediaType) {
        // System.out.println("req media type"+mediaType);
        return type == MyBean.class;
    }

    @Override
    public MyBean readFrom(Class<MyBean> type, Type type1, Annotation[] antns, MediaType mt, MultivaluedMap<String, String> mm, InputStream in) throws IOException, WebApplicationException {

        try {
            JAXBContext jaxbContext
                    = JAXBContext.newInstance(MyBean.class);
            Unmarshaller um = jaxbContext.createUnmarshaller();
            MyBean myBean = (MyBean) um.unmarshal(in);
            System.out.println("MyBeanMessageBodyReader:" + myBean);
            return myBean;
        } catch (JAXBException jaxbException) {
            Logger.getAnonymousLogger().severe(jaxbException.toString());
        }
        return null;
    }

}
