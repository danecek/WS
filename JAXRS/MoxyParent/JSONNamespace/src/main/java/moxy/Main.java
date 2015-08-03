/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moxy;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.eclipse.persistence.jaxb.*;

/**
 *
 * @author danecek
 */
public class Main {

    public static void main(String[] args) throws JAXBException {
      Address a1 = new Address("Major", 5);
        JAXBContext jaxbContext = JAXBContext.newInstance(Address.class);
        System.out.println(jaxbContext);
        Marshaller jsonMarshaller = jaxbContext.createMarshaller();
        jsonMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jsonMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, org.eclipse.persistence.oxm.MediaType.APPLICATION_JSON);//"eclipselink.media-type", "application/json");
        Map<String, String> namespaces = new HashMap<>();
        namespaces.put("oldnamespace", "newnamespace");
  jsonMarshaller.setProperty(MarshallerProperties.NAMESPACE_PREFIX_MAPPER, namespaces);
        StringWriter sw;

        jsonMarshaller.marshal(a1, sw = new StringWriter());
        System.out.println(sw);

//        Unmarshaller u = jaxbContext.createUnmarshaller();
//        u.setProperty(MarshallerProperties.NAMESPACE_PREFIX_MAPPER,
//                namespaces);
//        u.setProperty(MarshallerProperties.MEDIA_TYPE, org.eclipse.persistence.oxm.MediaType.APPLICATION_JSON);
//        StringReader sr = new StringReader(sw.toString());
//        System.out.println(u.unmarshal(sr));

    }

}
