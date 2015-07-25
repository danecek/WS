package jaxb;

import generated.ObjectFactory;
import generated.Record;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {

    static ObjectFactory of = new ObjectFactory();
    public static final File FILE = new File("greetings");

    static void masshalling() throws JAXBException {
        Record record = of.createRecord();
        record.setUser("tom");
        record.setMobil("0123456789");
        JAXBContext jc = JAXBContext.newInstance("generated");
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(record, FILE);
    }

    public static void main(String[] args) throws JAXBException, IOException {
        masshalling();
        Files.copy(FILE.toPath(), System.out);
    }
}
