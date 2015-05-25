/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.client;

//import ws.GreetingImplService;
import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.PortInfo;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import ws.service.Greeting;
import ws.service.GreetingImplService;

/**
 *
 * @author danecek
 */
public class WSClient {

    public static void main(String[] args) throws TransformerConfigurationException, TransformerException, SOAPException, IOException {
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");

        SOAPFactory sf = SOAPFactory.newInstance();
        MessageFactory f = MessageFactory.newInstance();
        SOAPMessage m = f.createMessage();
        SOAPBody b = m.getSOAPBody();
        SOAPElement op = b.addChildElement(sf.createElement(new QName("http://service.ws/", "sayHello", "ns2")));
        SOAPElement arg0 = op.addChildElement("arg0");
        arg0.addTextNode("Frank");
        m.writeTo(System.out);

        GreetingImplService gis = new GreetingImplService();
        Greeting port = gis.getGreetingImplPort();
        BindingProvider bp = (BindingProvider) port;
        bp.getRequestContext().put("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        bp.getBinding().setHandlerChain(Collections.<Handler>singletonList(new NewLogicalHandler()));

        Dispatch<SOAPMessage> d = gis.createDispatch(new QName("http://service.ws/", "GreetingImplPort"), SOAPMessage.class, Service.Mode.MESSAGE);
        SOAPMessage result = d.invoke(m);
        System.out.println(result.getSOAPBody().getTextContent());
        System.out.println(port.sayHello("George"));
        Dispatch<Source> ds = gis.createDispatch(new QName("http://service.ws/", "GreetingImplPort"), Source.class, Service.Mode.PAYLOAD);
        String payl = "<ns2:sayHello xmlns:ns2=\"http://service.ws/\"><arg0>George</arg0></ns2:sayHello>";
        Source results = ds.invoke(new StreamSource(new StringReader(payl)));

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.transform(results, new StreamResult(System.out));
    }

}
