package ws.service;

import java.io.IOException;
import javax.xml.ws.Endpoint;

public class WSPublisher {

    public static void main(String[] args) throws IOException {

        Endpoint endpoint = Endpoint.publish("http://localhost:8080/WS/Greeting", new GreetingProvider());
        System.in.read();
        endpoint.stop();
    }
}
