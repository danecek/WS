package jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

public class Main {

    public static void main(String[] args) throws JAXBException {

        JAXBContext jc = JAXBContext.newInstance("jaxb");
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        QName qtag = new QName("http://points", "point");
        @SuppressWarnings("unchecked")
        JAXBElement<Point> root = new JAXBElement(qtag, Point.class, new Point(10, 20));
        m.marshal(root, System.out);
        m.marshal(new RootPoint(2, 3), System.out);

    }
}
