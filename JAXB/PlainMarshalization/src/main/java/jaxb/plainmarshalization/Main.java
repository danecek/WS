/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.plainmarshalization;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author danecek
 */
public class Main {

    public static void main(String[] args) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(RootPoint.class);
        Marshaller m = jc.createMarshaller();
        m.marshal(new RootPoint(1, 2), System.out);
    }
}
