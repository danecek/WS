/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moxy;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import org.eclipse.persistence.jaxb.*;

/**
 *
 * @author danecek
 */
public class Main {

    public static void main(String[] args) throws JAXBException {
        // Step 1 - Create the Domain Model

        Address a1 = new Address("Major", 5);
        Address a2 = new Address("Minor", 7);

        JAXBContext jaxbContext = JAXBContext.newInstance(Address.class);
        System.out.println(jaxbContext);

        Marshaller m = jaxbContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //   m.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
        m.setProperty(MarshallerProperties.MEDIA_TYPE, org.eclipse.persistence.oxm.MediaType.APPLICATION_JSON);//"eclipselink.media-type", "application/json");
        StringWriter sw;

        m.marshal(new Address[]{new Address("Major", 5), new Address("Minor", 7)}, sw = new StringWriter());
        m.marshal(new Address[]{new Address("Major", 5), new Address("Minor", 7)}, System.out);
        System.out.println();

        Unmarshaller u = jaxbContext.createUnmarshaller();
        u.setProperty(MarshallerProperties.MEDIA_TYPE, org.eclipse.persistence.oxm.MediaType.APPLICATION_JSON);
        StringReader sr = new StringReader(sw.toString());
        //  StreamSource ss = new StreamSource(sr = new StringReader(sw.toString()));
        //  JAXBElement c = u.unmarshal(ss, Address.class);
        System.out.println(u.unmarshal(sr));
        //        List<JAXBElement<Address>> arr = (List<JAXBElement<Address>>) c.getValue();
        //        System.out.println(arr.get(0).getValue());

    }

}
