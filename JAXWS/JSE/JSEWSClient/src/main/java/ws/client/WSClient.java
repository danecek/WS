/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.client;

import ws.service.Greeting;
import ws.service.GreetingImplService;

/**
 *
 * @author lektor
 */
public class WSClient {

    public static void main(String[] args)  {
  //      System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
//        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
//        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        GreetingImplService ws = new GreetingImplService();
        Greeting p = ws.getGreetingImplPort();
        System.out.println(p.sayHello("Georg"));//, "Washington"));

    }
}
