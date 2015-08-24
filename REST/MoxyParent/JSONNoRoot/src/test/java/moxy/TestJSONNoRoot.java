/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moxy;

import java.io.IOException;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestJSONNoRoot {

    @Test
    public void hello() throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
        Customer c = Customer.create();
        String json = Main.marshall(c);
        Unmarshaller u = jaxbContext.createUnmarshaller();
        u.setProperty(MarshallerProperties.MEDIA_TYPE, org.eclipse.persistence.oxm.MediaType.APPLICATION_JSON);
        u.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
        JAXBElement<Customer> elem = u.unmarshal(new StreamSource(new StringReader(json)), Customer.class);
        assertEquals(c, elem.getValue());
    }
}
