/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.hwclient;

import javax.xml.ws.WebServiceRef;

/**
 *
 * @author danecek
 */
public class Main {

//    @WebServiceRef(wsdlLocation
//            = "http://localhost:8080/helloservice-war/HelloService?WSDL")
    private static final HelloServiceService service = new HelloServiceService();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(sayHello("world"));
    }

    private static String sayHello(java.lang.String arg0) {
        ws.hwclient.HelloService port = service.getHelloServicePort();
        return port.hello(arg0);
    }
}
