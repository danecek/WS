package jaxb;

import generated.ObjectFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

public class Main {

    static ObjectFactory of = new ObjectFactory();

    static <T> JAXBElement<T> wrap(String ns, String tag, T o) {
        QName qtag = new QName(ns, tag);
        Class<?> clazz = o.getClass();
        @SuppressWarnings("unchecked")
        JAXBElement<T> jbe = new JAXBElement(qtag, clazz, o);
        return jbe;
    }

    public static void main(String[] args) throws JAXBException {

        JAXBContext jc = JAXBContext.newInstance("jaxb");
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        JAXBElement<Point> root = wrap("http://points", "point", new Point(10, 20));
        m.marshal(root, System.out);
        m.marshal(new RootPoint(2, 3), System.out);

    }
}
