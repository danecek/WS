package ws.service;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import static javax.jws.soap.SOAPBinding.Style.*;
import static javax.jws.soap.SOAPBinding.Use.*;

@WebService()
@SOAPBinding(style = DOCUMENT, use = LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface Greeting {

    @WebMethod()
    @WebResult()
    String sayHello(@WebParam(name = "name") String name);//, @WebParam(name = "surname") String surname) throws Exception;

    @Oneway
    void oneWay();
}
