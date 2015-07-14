/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.client;

import javax.xml.ws.BindingProvider;
import ws.service.GenPoint;
import ws.service.GreetingImplService;
import ws.service.Point;

/**
 *
 * @author lektor
 */
public class WSClient {

    public static void main(String[] args) {
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        GreetingImplService ws = new GreetingImplService();
        GenPoint port = ws.getGreetingImplPort();
        BindingProvider bp = (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "danecek");
        Point p = port.createPoint("2", "5");
        System.out.printf("[%d, %d]\n", p.getX(), p.getY());
    }
}
