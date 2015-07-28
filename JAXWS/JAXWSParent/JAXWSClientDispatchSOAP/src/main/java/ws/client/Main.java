package ws.client;

import ws.service.Greeting;
import ws.service.GreetingImplService;

public class Main {

    public static void main(String[] args) {
        //      System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
//        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
//        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        GreetingImplService ws = new GreetingImplService();
        Greeting p = ws.getGreetingImplPort();
        System.out.println(p.sayHello("George"));

    }
}
