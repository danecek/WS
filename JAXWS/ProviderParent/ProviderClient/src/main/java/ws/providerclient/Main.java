/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.providerclient;

import java.io.StringReader;
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

/**
 *
 * @author danecek
 */
public class Main {

    public static void main(String[] args) throws TransformerConfigurationException, TransformerException {
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");

        QName sn = new QName("sn");
        Service s = Service.create(sn);
        QName pn = new QName("pn");
        s.addPort(pn, null, "http://localhost:8080/ProviderService/ProviderWebServiceService");
        Dispatch<Source> d = s.createDispatch(pn, Source.class, Service.Mode.PAYLOAD);
        Source res = d.invoke(new StreamSource(new StringReader("<x>aaaa</x>")));
        TransformerFactory tf = TransformerFactory.newInstance();
        final Transformer t = tf.newTransformer();
        t.transform(res, new StreamResult(System.out));
        //MyMessage arg0 = new MyMessage();
    }
}
