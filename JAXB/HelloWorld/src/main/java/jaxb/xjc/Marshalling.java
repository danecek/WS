package jaxb.xjc;

import generated.GreetingListType;
import generated.GreetingType;
import generated.ObjectFactory;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Marshalling {

    static ObjectFactory of = new ObjectFactory();

    static GreetingType newGrt(String text, String language) {
        GreetingType gt = of.createGreetingType();
        gt.setText(text);
        gt.setLanguage(language);
        return gt;
    }

    public static void main(String[] args) throws JAXBException {

        GreetingListType grtLst = of.createGreetingListType();
        grtLst.getGreeting().add(newGrt("hello", "en"));
        grtLst.getGreeting().add(newGrt("ahoj", "cs"));
        JAXBElement<GreetingListType> rootElm = of.createGreetings(grtLst);
        JAXBContext jc = JAXBContext.newInstance("generated");
        Marshaller m = jc.createMarshaller();
        m.setProperty("jaxb.formatted.output", true);
        m.marshal(rootElm, System.out);
        m.marshal(rootElm, new File("greetings"));
    }
}
