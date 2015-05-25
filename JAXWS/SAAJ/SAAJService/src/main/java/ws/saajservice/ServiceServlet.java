package ws.saajservice;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPMessage;

/**
 *
 * @author danecek
 */
@WebServlet(urlPatterns = {"/ServiceServlet"})
public class ServiceServlet extends HttpServlet {

    private MessageFactory messageFactory;
    private SOAPFactory soapFactory;

    @Override
    public void init() throws ServletException {
        try {
            messageFactory = MessageFactory.newInstance();
            soapFactory = SOAPFactory.newInstance();
        } catch (SOAPException ex) {
            Logger.getLogger(ServiceServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    private static int len(InputStream is) throws IOException {
        byte[] buff = new byte[1024];
        int len = 0;
        int read = 0;
        while ((read = is.read(buff, 0, buff.length)) != -1) {
            len += read;
        }
        return len;
    }

//    SOAPMessage createResponseMessage() throws SOAPException {
//        SOAPMessage responseMessage = messageFactory.createMessage();
//        SOAPBody responseBody = responseMessage.getSOAPBody();
//        responseBody.addTextNode(mess);
//        return responseMessage;
//    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (ServletOutputStream os = response.getOutputStream()) {
            response.setContentType("text/xml;charset=UTF-8");
            MimeHeaders mimeHeaders = new MimeHeaders();
            Enumeration en = request.getHeaderNames();
            while (en.hasMoreElements()) {
                String headerName = (String) en.nextElement();
                String headerVal = request.getHeader(headerName);
                StringTokenizer tk = new StringTokenizer(headerVal, ",");
                while (tk.hasMoreTokens()) {
                    mimeHeaders.addHeader(headerName, tk.nextToken().trim());
                }
            }
            SOAPMessage message
                    = messageFactory.createMessage(mimeHeaders, request.getInputStream());
            Iterator<AttachmentPart> attachments = message.getAttachments();
            AttachmentPart att = attachments.next();
            InputStream is = att.getDataHandler().getInputStream();
            SOAPMessage responseMessage = messageFactory.createMessage();
            SOAPBody responseBody = responseMessage.getSOAPBody();
            responseBody.addTextNode(Integer.toString(len(is)));
            responseMessage.writeTo(os);
        } catch (SOAPException se) {
            throw new ServletException(se);
        }
    }

}
