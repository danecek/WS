/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 *
 * @author danecek
 */
public class MySOAPHandler implements SOAPHandler<SOAPMessageContext> {

    Transformer t;

    public MySOAPHandler() {
        try {
            t = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(MySOAPHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void close(MessageContext context) {
    }

    public boolean handleMessage(SOAPMessageContext context) {
        try {
            ByteArrayOutputStream ba;
            context.getMessage().writeTo(ba = new ByteArrayOutputStream());
            System.out.println("******** MySOAPHandler:" +ba.toString());
        } catch (SOAPException ex) {
            Logger.getLogger(MySOAPHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MySOAPHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean handleFault(SOAPMessageContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Set<QName> getHeaders() {
       return null;
    }

}
