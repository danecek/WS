/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.hwclient;

import com.sun.xml.internal.ws.developer.JAXBContextFactory;
import com.sun.xml.internal.ws.util.xml.StAXSource;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceRef;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 *
 * @author danecek
 */
public class Main {

//    @WebServiceRef(wsdlLocation
//            = "http://localhost:8080/helloservice-war/HelloService?WSDL")
    private final static QName HELLOSERVICESERVICE_QNAME = new QName("http://wshelloworld.ws/", "HelloServicePort");

    private static final HelloServiceService service = new HelloServiceService();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TransformerException, TransformerConfigurationException, JAXBException {

        System.out.println(sayHello("world"));
    }

    private static String sayHello(java.lang.String arg0) throws TransformerConfigurationException, TransformerException, JAXBException {
        ws.hwclient.HelloService port = service.getHelloServicePort();
        Dispatch<Source> d = service.createDispatch(HELLOSERVICESERVICE_QNAME, Source.class, Service.Mode.PAYLOAD);
        JAXBContext c = JAXBContext.newInstance(Hello.class, HelloResponse.class);

        Dispatch<Object> jd = service.createDispatch(HELLOSERVICESERVICE_QNAME, c, Service.Mode.PAYLOAD);
        Object r = jd.invoke(new ObjectFactory().createHello(new Hello()));
        return r.toString();
//   
//        Source r = d.invoke(new StreamSource(new StringReader("<ns2:hello xmlns:ns2=\"http://wshelloworld.ws/\"/>")));
//   
//        TransformerFactory tf = TransformerFactory.newInstance();
//        Transformer t = tf.newTransformer();
//        StringWriter sw;
//        t.transform(r, new StreamResult(sw = new StringWriter()));
//        return sw.toString();
//        // return port.hello(arg0);
    }
}
