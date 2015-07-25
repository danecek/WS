/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb;

import javax.xml.bind.JAXBException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danecek
 */
public class MainTest {

    public MainTest() {
    }

    @Before
    public void setUp() throws JAXBException {
        Main.masshalling();
    }

    @Test
    public void test() throws JAXBException {
    }
}
