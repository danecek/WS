/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moxy;

import java.io.StringReader;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import junit.framework.Assert;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.junit.Test;

/**
 *
 * @author danecek
 */
public class JSONCollectiionsTest {

    public JSONCollectiionsTest() {
    }

    @Test
    public void test() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(RootAddress.class);
        Unmarshaller u = jaxbContext.createUnmarshaller();
        u.setProperty(MarshallerProperties.MEDIA_TYPE, org.eclipse.persistence.oxm.MediaType.APPLICATION_JSON);
        Object o = u.unmarshal(new StringReader(Main.marshall()));
        Assert.assertEquals(Arrays.asList(Main.createData()), o);

    }

}
