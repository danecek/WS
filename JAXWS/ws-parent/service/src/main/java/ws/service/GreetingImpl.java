package ws.service;

import javax.jws.WebService;

@WebService(endpointInterface = "ws.service.Greeting")
public class GreetingImpl implements Greeting {

    @Override
    public String sayHello(String name) {
        return "Hello, Welcom to jax-ws " + name;
    }

}
