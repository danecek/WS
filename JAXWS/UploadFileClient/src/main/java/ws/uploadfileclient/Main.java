/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.uploadfileclient;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

/**
 *
 * @author danecek
 */
public class Main {

    public static void main(String[] args) {

        try { // Call Web Service Operation
            UploadImplService service = new UploadImplService();
            UploadImpl port = service.getUploadImplPort();
            // TODO initialize WS operation arguments here

            DataHandler arg1 = new DataHandler(new FileDataSource("pom.xml"));
            System.out.println(port.fileUpload("xxxx", arg1));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
