package ws.client;

import java.io.StringReader;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;

import ws.service.GreetingImplService;

public class Main {

    public static void main(String[] args) throws Exception {
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        GreetingImplService gis = new GreetingImplService();
        Dispatch<Source> ds = gis.createDispatch(new QName("http://service.ws/", "GreetingImplPort"), Source.class, Service.Mode.PAYLOAD);
        String pay2 = "<ns2:oneWay xmlns:ns2=\"http://service.ws/\"><name xmlns=\"\">Frank</name></ns2:oneWay>";
        ds.invokeOneWay(new StreamSource(new StringReader(pay2)));
    }

}
