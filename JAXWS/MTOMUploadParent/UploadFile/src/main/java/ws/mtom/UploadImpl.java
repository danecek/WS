/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.mtom;

import com.sun.xml.ws.developer.StreamingDataHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.activation.DataHandler;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

@MTOM
@WebService
public class UploadImpl {

    // Use @XmlMimeType to map to DataHandler on the client side
    public String fileUpload(String name,
       //     @XmlMimeType("application/x-binary") 
                    DataHandler data) {
        Path p;
        try {
            StreamingDataHandler dh = (StreamingDataHandler) data;
            p = Paths.get(System.getProperty("user.home") + "/" + name);
            Files.copy(dh.getInputStream(), p);
//            BufferedReader br = new BufferedReader(new InputStreamReader(dh.getInputStream()));
            //  b1 = dh.getInputStream().read();
            //     fl = br.readLine();
            //   System.out.println(fl);
            return Files.size(p)+"";
        } catch (Exception e) {
            throw new WebServiceException(e);
        }

    }
}
