package ws.client;

import java.io.StringReader;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Response;
import javax.xml.ws.Service;

import ws.service.GreetingImplService;

public class Main {

    public static void main(String[] args) throws Exception {
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        GreetingImplService gis = new GreetingImplService();
        Dispatch<Source> ds = gis.createDispatch(new QName("http://service.ws/", "GreetingImplPort"), Source.class, Service.Mode.PAYLOAD);
        String pay2 = "<ns2:sayHello xmlns:ns2=\"http://service.ws/\"><name xmlns=\"\">Frank</name></ns2:sayHello>";
        ds.invokeAsync(new StreamSource(new StringReader(pay2)), new AsyncHandler<Source>() {

            @Override
            public void handleResponse(Response<Source> res) {
                try {
                    TransformerFactory tf = TransformerFactory.newInstance();
                    final Transformer t = tf.newTransformer();
                    t.transform(res.get(), new StreamResult(System.out));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ExecutionException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TransformerException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        System.in.read();
    }

}
