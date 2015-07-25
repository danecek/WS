/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {

    public static void main(String[] args) throws JAXBException {
        ItemsMap b = new ItemsMap();

        Root root = new Root();
        root.items = b;
        b.addItems(1, "one");
        b.addItems(2, "two");
        JAXBContext jc = JAXBContext.newInstance(ItemsMap.class, ItemsList.class, Root.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(root, System.out);

    }
}
