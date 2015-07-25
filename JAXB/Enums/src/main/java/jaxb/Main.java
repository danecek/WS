/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb;

import generated.IXLType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.namespace.QName;

/**
 *
 * @author danecek
 */
public class Main {

    public static void main(String[] args) throws DatatypeConfigurationException, JAXBException {

        JAXBContext jc = JAXBContext.newInstance(IXLType.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        IXLType ixlt = IXLType.E_STW_A;
        m.marshal(new JAXBElement<IXLType>(new QName("ixlelement"), IXLType.class, ixlt), System.out);
    }
}
