/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.client;

//import ws.GreetingImplService;
import ws.service.Greeting;
import ws.service.GreetingImplService;

/**
 *
 * @author danecek
 */
public class WSClient {

    public static void main(String[] args) {
        GreetingImplService gis = new GreetingImplService();
        Greeting port = gis.getGreetingImplPort();
        System.out.println(port.sayHello("George"));
    }

}
