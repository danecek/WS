package jaxb;

import generated.NewElementType;
import generated.ObjectFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {

    static ObjectFactory of = new ObjectFactory();
    public static final File FILE = new File("newelement");

    static void marshalling() throws JAXBException {
        NewElementType newElement = of.createNewElementType();
        newElement.setGroup(3);
        JAXBElement<NewElementType> rootElm = of.createNewElement(newElement);
        JAXBContext jc = JAXBContext.newInstance("generated");
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(rootElm, FILE);
    }

    public static void main(String[] args) throws JAXBException, IOException {
        marshalling();
        Files.copy(FILE.toPath(), System.out);
    }
}
