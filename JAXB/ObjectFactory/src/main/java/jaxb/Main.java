package jaxb;

import generated.Circle;
import generated.ObjectFactory;
import generated.SquareType;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {

    public static void main(String[] args) throws JAXBException, IOException {
        ObjectFactory of = new ObjectFactory();
        Circle circle = of.createCircle();
        circle.setRadius(2.2);
        SquareType squareValue = of.createSquareType();
        JAXBElement<SquareType> square = of.createSquare(squareValue);
        JAXBContext jc = JAXBContext.newInstance("generated");
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(circle, System.out);
        m.marshal(square, System.out);
    }
}
