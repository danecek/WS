/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.xjc;

import generated.NumericZooType;
import generated.ObjectFactory;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author danecek
 */
public class Main {

    public static void main(String[] args) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance("generated");
        ObjectFactory of = new ObjectFactory();
        NumericZooType nzt = of.createNumericZooType();
        nzt.setDecimal(BigDecimal.ONE);
        nzt.setInteger(BigInteger.ZERO);
        int value = 3;
        nzt.setLong(value++);
        nzt.setInt(value++);
        nzt.setShortNil(Short.MAX_VALUE);
        nzt.setByte(Byte.MIN_VALUE);
        nzt.setNonNegative(BigInteger.TEN);
        nzt.setUnsignedLong(BigInteger.ONE);
        nzt.setUnsignedInt(value++);
        JAXBElement<NumericZooType> je = of.createNumericZoo(nzt);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(je, System.out);
    }

}
