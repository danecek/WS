package jaxb.xjc;

import generated.JavaObjectType;
import generated.ObjectFactory;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Marshalling {
    
    public static void main(String[] args) throws JAXBException {
        ObjectFactory of = new ObjectFactory();
        JavaObjectType javaObject = of.createJavaObjectType();        
        javaObject.setData(new byte[]{-1, 1, -128, 127});
        JAXBElement<JavaObjectType> rootElm = of.createJavaObject(javaObject);
        
        JAXBContext jc = JAXBContext.newInstance("generated");
        Marshaller m = jc.createMarshaller();
        m.setProperty("jaxb.formatted.output", true);
        m.marshal(rootElm, System.out);
        m.marshal(rootElm, new File("greetings"));
    }
}
