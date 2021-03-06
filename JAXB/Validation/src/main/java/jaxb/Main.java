package jaxb;

import generated.GreetingType;
import generated.ObjectFactory;
import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

public class Main {

    public static void main(String[] args) throws JAXBException, SAXException {
        ObjectFactory of = new ObjectFactory();
        GreetingType greeting = of.createGreetingType();
        greeting.setText("hello");
        JAXBElement<GreetingType> rootElm = of.createGreeting(greeting);
        JAXBContext jc = JAXBContext.newInstance("generated");

        Marshaller m = jc.createMarshaller();
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema s = sf.newSchema(Void.TYPE.getResource("/invalidschema/invalidXmlSchema.xsd"));
        m.setSchema(s);
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    //    m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, args);
        m.setEventHandler(new ValidationEventHandler() {

            @Override
            public boolean handleEvent(ValidationEvent event) {
                System.out.println(event);
                return true;
            }
        });
        m.marshal(rootElm, System.out);
    }
}
