package ws.client;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import ws.service.GreetingImplService;
import ws.service.ObjectFactory;
import ws.service.SayHello;
import ws.service.SayHelloResponse;

public class Main {

    public static void main(String[] args) throws Exception {
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");

        GreetingImplService gis = new GreetingImplService();
        JAXBContext jaxbc = JAXBContext.newInstance("ws.service");
        ObjectFactory of = new ObjectFactory();

        Dispatch<Object> d = gis.createDispatch(new QName("http://service.ws/", "GreetingImplPort"), jaxbc, Service.Mode.PAYLOAD);
        SayHello sh = of.createSayHello();
        sh.setName("Geroge");
        JAXBElement<SayHelloResponse> result = (JAXBElement<SayHelloResponse>) d.invoke(of.createSayHello(sh));
        System.out.println(result.getValue().getReturn());
    }

}
