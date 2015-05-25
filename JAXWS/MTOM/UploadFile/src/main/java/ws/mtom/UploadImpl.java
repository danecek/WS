/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.mtom;

import com.sun.xml.ws.developer.StreamingDataHandler;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.activation.DataHandler;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

@MTOM
@WebService
public class UploadImpl {

    // Use @XmlMimeType to map to DataHandler on the client side
    public String fileUpload(String name,
            @XmlMimeType("application/octet-stream") DataHandler data) {
        String fl = "undefined";
        try {
            StreamingDataHandler dh = (StreamingDataHandler) data;
            BufferedReader br = new BufferedReader(new InputStreamReader(dh.getInputStream()));
            fl = br.readLine();
            System.out.println(fl);
        } catch (Exception e) {
            throw new WebServiceException(e);
        }
        return fl;

    }
}
