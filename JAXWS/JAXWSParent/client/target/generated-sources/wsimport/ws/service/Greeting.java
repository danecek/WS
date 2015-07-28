
package ws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Greeting", targetNamespace = "http://service.ws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Greeting {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://service.ws/", className = "ws.service.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://service.ws/", className = "ws.service.SayHelloResponse")
    @Action(input = "http://service.ws/Greeting/sayHelloRequest", output = "http://service.ws/Greeting/sayHelloResponse")
    public String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
