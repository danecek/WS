/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

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

    public static void main(String[] args) throws JAXBException {
        // Step 1 - Create the Domain Model

        Customer customer = new Customer();
        customer.setName("Jane Doe");

        Address address = new Address();
        address.setStreet("123 Any Street");
        address.setCity("My Town");
        customer.setAddress(address);

        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
        System.out.println(jaxbContext);

        Marshaller m = jaxbContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.setProperty(MarshallerProperties.MEDIA_TYPE, org.eclipse.persistence.oxm.MediaType.APPLICATION_JSON);//"eclipselink.media-type", "application/json");
        StringWriter sw;

        m.marshal(customer, sw = new StringWriter());
        System.out.println(sw);

//        Unmarshaller u = jaxbContext.createUnmarshaller();
//        u.setProperty(MarshallerProperties.MEDIA_TYPE, org.eclipse.persistence.oxm.MediaType.APPLICATION_JSON);
//        Customer c = (Customer) u.unmarshal(new StringReader(sw.toString()));
//        System.out.println(c);

    }

}
