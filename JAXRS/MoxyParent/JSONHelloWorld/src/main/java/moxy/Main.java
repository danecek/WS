/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moxy;

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

        Customer customer = Customer.create();

        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
        System.out.println(jaxbContext);

        Marshaller m = jaxbContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.setProperty(MarshallerProperties.MEDIA_TYPE, org.eclipse.persistence.oxm.MediaType.APPLICATION_JSON);

        m.marshal(customer, System.out);

    }

}
