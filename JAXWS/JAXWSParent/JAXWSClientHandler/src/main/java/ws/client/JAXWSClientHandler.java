package ws.client;

import java.io.IOException;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;

import ws.service.Greeting;
import ws.service.GreetingImplService;

/**
 *
 * @author danecek
 */
public class JAXWSClientHandler {

    static SOAPMessage createRequest() throws SOAPException, IOException {
        SOAPFactory sf = SOAPFactory.newInstance();
        MessageFactory f = MessageFactory.newInstance();
        SOAPMessage m = f.createMessage();
        SOAPBody b = m.getSOAPBody();
        SOAPElement op = b.addChildElement(sf.createElement(new QName("http://service.ws/", "sayHello", "ns2")));
        SOAPElement arg0 = op.addChildElement("name");
        arg0.addTextNode("Geroge");
        return m;
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");

        GreetingImplService gis = new GreetingImplService();
        Greeting port = gis.getGreetingImplPort();
        BindingProvider bp = (BindingProvider) port;
        List<Handler> handlerList = bp.getBinding().getHandlerChain();
        handlerList.add(new NewLogicalHandler());
        Dispatch<SOAPMessage> d = gis.createDispatch(new QName("http://service.ws/", "GreetingImplPort"), SOAPMessage.class, Service.Mode.MESSAGE);
        SOAPMessage result = d.invoke(createRequest());
        System.out.println(result.getSOAPBody().getTextContent());
        System.in.read();
    }

}
