/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.saajclient;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

/**
 *
 * @author danecek
 */
public class FileLength {

    static FileLength instance = new FileLength();

    public FileLength() {
        try {
            factory = SOAPConnectionFactory.newInstance();
            connection = factory.createConnection();
            endpoint = new URL("http://localhost:8080/SAAJService/ServiceServlet");
            mf = MessageFactory.newInstance();
        } catch (SOAPException | UnsupportedOperationException | MalformedURLException ex) {
            Logger.getLogger(FileLength.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    SOAPConnectionFactory factory;
    SOAPConnection connection;
    URL endpoint;
    MessageFactory mf;

    String textLength(File f) throws SOAPException {
        DataHandler dh = new DataHandler(new FileDataSource(f));
        SOAPMessage message = mf.createMessage();
        AttachmentPart a = message.createAttachmentPart(dh);
        message.addAttachmentPart(a);
        SOAPMessage response = connection.call(message, endpoint);
        SOAPBody responseBody = response.getSOAPBody();
        return responseBody.getTextContent();
    }

}
