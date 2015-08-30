/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.asyncclient;

import javax.ws.rs.client.*;
import restful.tools.Tools;
import javax.ws.rs.core.*;

public class AsyncClientMain {

    private static final String BASE_URI = "http://localhost:8080/AsyncHelloWorldServer";

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget resource = client.target(BASE_URI).path("webresources/asyncresource");
        String resp = resource.request().get(String.class);
        System.out.println(resp);
        client.close();
    }

}
