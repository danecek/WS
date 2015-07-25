package jaxb;

import generated.BinaryType;
import generated.ObjectFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {

    public static void main(String[] args) throws JAXBException {
        ObjectFactory of = new ObjectFactory();
        BinaryType binary = of.createBinaryType();
        binary.setData(new byte[]{-1, 1, -128, 127});
        JAXBElement<BinaryType> rootElm = of.createBinary(binary);

        JAXBContext jc = JAXBContext.newInstance("generated");
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(rootElm, System.out);
    }
}
