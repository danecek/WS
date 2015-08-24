/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moxy;

import java.io.IOException;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.eclipse.persistence.jaxb.*;

/**
 *
 * @author danecek
 */
public class Main {

    public static String marshall(Customer customer) throws JAXBException, IOException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
        System.out.println(jaxbContext);

        Marshaller m = jaxbContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
        m.setProperty(MarshallerProperties.MEDIA_TYPE, org.eclipse.persistence.oxm.MediaType.APPLICATION_JSON);//"eclipselink.media-type", "application/json");
        StringWriter sw;

        m.marshal(customer, sw = new StringWriter());
        sw.close();
        return sw.toString();
    }

    public static void main(String[] args) throws JAXBException, IOException {
        Customer customer = Customer.create();
        //  String json = sw.toString();
        System.out.println(marshall(customer));

//        Unmarshaller u = jaxbContext.createUnmarshaller();
//        u.setProperty(MarshallerProperties.MEDIA_TYPE, org.eclipse.persistence.oxm.MediaType.APPLICATION_JSON);
//        u.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
//        JAXBElement<Customer> c = u.unmarshal(new StreamSource(new StringReader(json)), Customer.class);
//        System.out.println(c.getValue());
    }

}
