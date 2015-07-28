package jaxb;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.naming.spi.ObjectFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {

    static ObjectFactory of = new ObjectFactory();
    public static final File FILE = new File("greetings");

    static GreetingType newGrt(String text, String language) {
        GreetingType gt = of.createGreetingType();
        gt.setText(text);
        gt.setLanguage(language);
        return gt;
    }

    static void masshalling() throws JAXBException {
        GreetingListType grtLst = of.createGreetingListType();
        grtLst.getGreeting().add(newGrt("hello", "en"));
        grtLst.getGreeting().add(newGrt("ahoj", "cs"));
        JAXBElement<GreetingListType> rootElm = of.createGreetings(grtLst);
        JAXBContext jc = JAXBContext.newInstance("generated");
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(rootElm, FILE);
    }

    public static void main(String[] args) throws JAXBException, IOException {
        masshalling();
        Files.copy(FILE.toPath(), System.out);
    }
}
