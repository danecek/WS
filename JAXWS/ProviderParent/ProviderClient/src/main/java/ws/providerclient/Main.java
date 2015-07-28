/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.providerclient;

/**
 *
 * @author danecek
 */
public class Main {

    public static void main(String[] args) {

//        try { // Call Web Service Operation
            ProviderWebServiceService service = new ProviderWebServiceService();
            ws.providerclient.ProviderWebService port = service.getProviderWebServicePort();
            // TODO initialize WS operation arguments here
            MyMessage arg0 = new MyMessage();
            // TODO process result here
            MyMessage result = port.invoke(arg0);
            System.out.println("Result = " + result);
//        } catch (Exception ex) {
//            // TODO handle custom exceptions here
//        }

    }
}
