/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.xjc;

import generated.DateTimeType;
import generated.ObjectFactory;
import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author danecek
 */
public class Main {

    public static void main(String[] args) throws DatatypeConfigurationException, JAXBException {
        // DateTimeType element for the current time and date.
        ObjectFactory of = new ObjectFactory();
        DateTimeType rootElement = of.createDateTimeType();
        GregorianCalendar now = new GregorianCalendar();

// Obtain a DatatypeFactory instance:
        DatatypeFactory df = DatatypeFactory.newInstance();
        // Create an XMLGregorianCalendar with the current date.
        XMLGregorianCalendar gcDate = df.newXMLGregorianCalendarDate(
                now.get(Calendar.YEAR), now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH),
                DatatypeConstants.FIELD_UNDEFINED);

// Create an XMLGregorianCalendar with the current time.
        XMLGregorianCalendar gcTime
                = df.newXMLGregorianCalendarTime(
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        now.get(Calendar.SECOND),
                        null, // no fraction
                        DatatypeConstants.FIELD_UNDEFINED);
        // Insert sub-elements into the DateTimeType element.
        rootElement.setDate(gcDate);
        rootElement.setTime(gcTime);
        System.out.printf("date: %s\n", gcDate);
        System.out.printf("time: %s\n", gcTime);
        JAXBContext jc = JAXBContext.newInstance("generated");
        Marshaller m = jc.createMarshaller();
        m.setProperty("jaxb.formatted.output", true);
        m.marshal(of.createDateTime(rootElement), System.out);
    }
}
