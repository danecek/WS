/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.xmlentityproviders;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.ws.rs.*;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.*;
import java.lang.reflect.*;
import javax.xml.bind.Marshaller;
//import org.eclipse.persistence.jaxb.*;

@Produces({"application/xml"})
@Provider
public class MyBeanMessageBodyWriter implements
        MessageBodyWriter<MyBean> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType,
            Annotation[] annotations, javax.ws.rs.core.MediaType mediaType) {
        // System.out.println("req media type"+mediaType);
        return type == MyBean.class;
    }

    @Override
    public void writeTo(MyBean myBean, Class<?> type,
            Type genericType, Annotation[] annotations,
            javax.ws.rs.core.MediaType mediaType,
            MultivaluedMap<String, Object> httpHeaders,
            OutputStream entityStream) throws IOException,
            WebApplicationException {
        try {
            JAXBContext jaxbContext
                    = JAXBContext.newInstance(MyBean.class);
    //        System.out.println(jaxbContext);

            Marshaller m = jaxbContext.createMarshaller();
  //          m.setProperty(MarshallerProperties.MEDIA_TYPE, org.eclipse.persistence.oxm.MediaType.APPLICATION_JSON);
//"eclipselink.media-type", "application/json");
            StringWriter sw = new StringWriter();
            m.marshal(myBean, sw);
            String entity = sw.toString();
            System.out.println(entity);
            entityStream.write(entity.getBytes());
            entityStream.close();
        } catch (JAXBException jaxbException) {
        }
    }

    @Override
    public long getSize(MyBean t, Class<?> type, java.lang.reflect.Type type1, Annotation[] antns, javax.ws.rs.core.MediaType mt) {
        return 0;
    }

}
