/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb;

import generated.NewElementType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author danecek
 */
public class MainTest {

    public MainTest() {
    }

    @Before
    public void setUp() throws JAXBException {
        Main.marshalling();
    }

    @Test
    public void hello() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance("generated");
        Unmarshaller m = jc.createUnmarshaller();
        JAXBElement<NewElementType> element = (JAXBElement) m.unmarshal(Main.FILE);
        assertEquals(3, element.getValue().getGroup().intValue());
    }
}
