package moxy;

import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.eclipse.persistence.jaxb.*;

public class Main {

    static RootAddress[] createData() {
        RootAddress a1 = new RootAddress("Major");
        RootAddress a2 = new RootAddress("Minor");
        return new RootAddress[]{a1, a2};
    }

    static String marshall() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(RootAddress.class);
        System.out.println(jaxbContext);
        Marshaller m = jaxbContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.setProperty(MarshallerProperties.MEDIA_TYPE, org.eclipse.persistence.oxm.MediaType.APPLICATION_JSON);
        StringWriter sw;
        m.marshal(createData(), sw = new StringWriter());
        return sw.toString();
    }

    public static void main(String[] args) throws JAXBException {
        System.out.println(marshall());
    }

}
