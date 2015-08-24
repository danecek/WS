/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;


public class AsyncClientMain {


    private static final String BASE_URI = "http://localhost:8080/webserver/webresources";


    public static void main(String[] args) {
        Client client = javax.ws.rs.client.ClientBuilder.newClient();
        WebTarget webTarget = client.target(BASE_URI).path("asyncresource");
        WebTarget resource = webTarget;
        String resp = resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(String.class);
        System.out.println(resp);
        client.close();
    }

}
