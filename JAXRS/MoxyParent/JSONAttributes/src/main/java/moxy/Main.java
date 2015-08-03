/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moxy;

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
        Address a1 = new Address("Major", "Sin City");
        JAXBContext jaxbContext = JAXBContext.newInstance(Address.class);
        System.out.println(jaxbContext);
        Marshaller jsonMarshaller = jaxbContext.createMarshaller();
        jsonMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jsonMarshaller.setProperty(
                MarshallerProperties.JSON_ATTRIBUTE_PREFIX, "@");
        jsonMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, org.eclipse.persistence.oxm.MediaType.APPLICATION_JSON);//"eclipselink.media-type", "application/json");
        StringWriter sw;

        jsonMarshaller.marshal(a1, System.out);//sw = new StringWriter());
        //  System.out.println(sw);
    }

}
