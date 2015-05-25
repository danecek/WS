package ws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import static javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED;
import static javax.jws.soap.SOAPBinding.Style.DOCUMENT;
import static javax.jws.soap.SOAPBinding.Use.LITERAL;

@WebService
@SOAPBinding(parameterStyle = WRAPPED, style = DOCUMENT, use = LITERAL)
public interface Greeting {
	 @WebMethod String sayHello(String name);
}