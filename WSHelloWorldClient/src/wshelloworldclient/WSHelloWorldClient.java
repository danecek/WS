/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wshelloworldclient;

import generated.HelloWebService;
import generated.HelloWebService_Service;

/**
 *
 * @author Student
 */
public class WSHelloWorldClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HelloWebService_Service wsf = new HelloWebService_Service();
        HelloWebService port = wsf.getHelloWebServicePort();
        System.out.println(port.hello("Tom"));
        // TODO code application logic here
    }
    
}
