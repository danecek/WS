/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.xjc;

import generated.GreetingListType;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UnMarshalling {

    public static void main(String[] args) throws JAXBException {

        JAXBContext jc = JAXBContext.newInstance("generated");
        Unmarshaller m = jc.createUnmarshaller();
        JAXBElement<GreetingListType> element = (JAXBElement) m.unmarshal(new File("greetings"));
        GreetingListType greetingList = element.getValue();
    }
}
