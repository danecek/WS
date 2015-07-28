/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.client;

//import ws.GreetingImplService;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import ws.service.GreetingImplService;
import ws.service.ObjectFactory;
import ws.service.SayHelloResponse;

/**
 *
 * @author danecek
 */
public class WSDispachClient {

    static SOAPMessage createRequest() throws SOAPException, IOException {
        SOAPFactory sf = SOAPFactory.newInstance();
        MessageFactory f = MessageFactory.newInstance();
        SOAPMessage m = f.createMessage();
        SOAPBody b = m.getSOAPBody();
        SOAPElement op = b.addChildElement(sf.createElement(new QName("http://service.ws/", "sayHello", "ns2")));
        SOAPElement arg0 = op.addChildElement("name");
        arg0.addTextNode("Frank");
        System.out.print("created SOAP:");
        m.writeTo(System.out);
        return m;
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");

        GreetingImplService gis = new GreetingImplService();
//        Greeting port = gis.getGreetingImplPort();
//        BindingProvider bp = (BindingProvider) port;
//        bp.getRequestContext().put("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//        bp.getBinding().setHandlerChain(Collections.<Handler>singletonList(new NewLogicalHandler()));
//        Dispatch<SOAPMessage> d = gis.createDispatch(new QName("http://service.ws/", "GreetingImplPort"), SOAPMessage.class, Service.Mode.MESSAGE);
//        SOAPMessage result = d.invoke(createRequest());
//        System.out.println("SOAPBody TextContent: " + result.getSOAPBody().getTextContent());
//        System.out.println("******************************************************");
//
//        Dispatch<Source> ds = gis.createDispatch(new QName("http://service.ws/", "GreetingImplPort"), Source.class, Service.Mode.PAYLOAD);
//        String payl = "<ns2:sayHello xmlns:ns2=\"http://service.ws/\"><name xmlns=\"\">Frank</name></ns2:sayHello>";
//        Source results = ds.invoke(new StreamSource(new StringReader(payl)));
//
//        TransformerFactory tf = TransformerFactory.newInstance();
//        final Transformer t = tf.newTransformer();
//        t.transform(results, new StreamResult(System.out));
//        System.out.println("**************************************************************");
//
//        Dispatch<Source> ds2 = gis.createDispatch(new QName("http://service.ws/", "GreetingImplPort"), Source.class, Service.Mode.PAYLOAD);
//        String pay2 = "<ns2:sayHello xmlns:ns2=\"http://service.ws/\"><name xmlns=\"\">Frank</name></ns2:sayHello>";
//        ds2.invokeAsync(new StreamSource(new StringReader(pay2)), new AsyncHandler<Source>() {
//
//            @Override
//            public void handleResponse(Response<Source> res) {
//                try {
//
//                    t.transform(res.get(), new StreamResult(System.out));
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(WSDispachClient.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ExecutionException ex) {
//                    Logger.getLogger(WSDispachClient.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (TransformerException ex) {
//                    Logger.getLogger(WSDispachClient.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//        System.in.read();
        JAXBContext jc = JAXBContext.newInstance("ws.service");

        ObjectFactory of = new ObjectFactory();
        Dispatch<Object> dso = gis.createDispatch(new QName("http://service.ws/", "GreetingImplPort"), jc, Service.Mode.PAYLOAD);
        // String payl = "<ns2:sayHello xmlns:ns2=\"http://service.ws/\"><name xmlns=\"\">Frank</name></ns2:sayHello>";
        JAXBElement<SayHelloResponse> resultO = (JAXBElement<SayHelloResponse>) dso.invoke(of.createSayHello(of.createSayHello()));
        System.out.println(resultO.getValue().getReturn());
    }

}
