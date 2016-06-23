package ws.client;

import java.io.IOException;
import java.io.StringReader;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stax.StAXResult;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ws.service.GreetingImplService;

public class Main {

    public static void main(String[] args) throws TransformerConfigurationException, TransformerException, ParserConfigurationException, SAXException, IOException, XMLStreamException {
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        GreetingImplService gis = new GreetingImplService();
        Dispatch<Source> ds = gis.createDispatch(new QName("http://service.ws/", "GreetingImplPort"), Source.class, Service.Mode.PAYLOAD);
        String payl = "<ns2:sayHello xmlns:ns2=\"http://service.ws/\"><name xmlns=\"\">Frank</name></ns2:sayHello>";
        Source results = ds.invoke(new StreamSource(new StringReader(payl)));

        TransformerFactory tf = TransformerFactory.newInstance();
        final Transformer t = tf.newTransformer();
        

        t.transform(results, new StreamResult(System.out));
        System.out.println("**************************************************************");
        
        t.transform(results, new StAXResult(new XMLEventWriter() {
            public void flush() throws XMLStreamException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            public void close() throws XMLStreamException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            public void add(XMLEvent event) throws XMLStreamException {
                System.out.println(event);
            }

            public void add(XMLEventReader reader) throws XMLStreamException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            public String getPrefix(String uri) throws XMLStreamException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            public void setPrefix(String prefix, String uri) throws XMLStreamException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            public void setDefaultNamespace(String uri) throws XMLStreamException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            public void setNamespaceContext(NamespaceContext context) throws XMLStreamException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            public NamespaceContext getNamespaceContext() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }));
        System.out.println("**************************************************************");
    }
}
