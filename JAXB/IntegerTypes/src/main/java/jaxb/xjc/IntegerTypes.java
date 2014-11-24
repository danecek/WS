/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.xjc;

import generated.NumericZooType;
import generated.ObjectFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author danecek
 */
public class IntegerTypes {

    public static void main(String[] args) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance("generated");
        ObjectFactory of = new ObjectFactory();
        NumericZooType nzt = of.createNumericZooType();
        JAXBElement<NumericZooType> je = of.createNumericZoo(nzt);
        Marshaller m = jc.createMarshaller();
        m.setProperty("jaxb.formatted.output", true);
        m.marshal(je, System.out);
 
    }

}
