package jaxb.rsservice;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.eclipse.persistence.jaxb.MarshallerProperties;

@Produces(APPLICATION_JSON)
//@Provider
public class MyBeanMessageBodyWriter implements
        MessageBodyWriter<MyBean> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType) {
        return type == MyBean.class;
    }

    // deprecated by JAX-RS 2.0 and ignored by Jersey runtime
    @Override
    public void writeTo(MyBean myBean, Class<?> type,
            Type genericType, Annotation[] annotations,
            MediaType mediaType,
            MultivaluedMap<String, Object> httpHeaders,
            OutputStream entityStream) throws IOException,
            WebApplicationException {
        try {
            System.out.println("sssssssssssssssssssssssssssssssssssssssssssssss");
            JAXBContext jaxbContext
                    = JAXBContext.newInstance(MyBean.class);
            Marshaller m = jaxbContext.createMarshaller();
            m.setProperty(MarshallerProperties.MEDIA_TYPE,
                    "application/json");

            m.marshal(myBean,
                    entityStream);
        } catch (JAXBException jaxbException) {
        }
    }

    public long getSize(MyBean t, Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return 0;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
