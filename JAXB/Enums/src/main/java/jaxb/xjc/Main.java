/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.xjc;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;

/**
 *
 * @author danecek
 */
public class Main {

    public static void main(String[] args) throws DatatypeConfigurationException, JAXBException {

        JAXBContext jc = JAXBContext.newInstance("generated");
        Marshaller m = jc.createMarshaller();
        m.setProperty("jaxb.formatted.output", true);
        //      m.marshal(of.createDateTime(rootElement), System.out);
    }
}
