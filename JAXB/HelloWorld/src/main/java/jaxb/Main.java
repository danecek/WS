package jaxb;

import generated.ObjectFactory;
import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

public class Main {

    static ObjectFactory of = new ObjectFactory();
    public static final File FILE = new File("greetings");

    public static void main(String[] args) throws JAXBException, IOException {
        JAXBContext ctx = JAXBContext.newInstance(Shape.class);
        Marshaller m = ctx.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        JAXBElement<Circle> root = new JAXBElement(new QName("circle"), Circle.class, new Circle(2));

        m.marshal(root, System.out);
    }
}
