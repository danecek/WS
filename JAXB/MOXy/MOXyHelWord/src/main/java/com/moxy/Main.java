/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moxy;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

/**
 *
 * @author danecek
 */
public class Main {

    public static void main(String[] args) throws JAXBException {
           // Step 1 - Create the Domain Model

        Customer customer = new Customer();
        customer.setName("Jane Doe");

        Address address = new Address();
        address.setStreet("123 Any Street");
        address.setCity("My Town");
        customer.setAddress(address);


       

        // Step 2 - Convert the Domain Model to XML
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
       // System.out.println(jaxbContext);
        System.out.println(jaxbContext.toString());

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        JAXBElement<Customer> jaxbElement = new JAXBElement<>(new QName(null, "customer"), Customer.class, customer);
        marshaller.marshal(jaxbElement, System.out);

    }

}
