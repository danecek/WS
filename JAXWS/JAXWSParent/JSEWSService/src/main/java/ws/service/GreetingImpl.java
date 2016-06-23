package ws.service;

import javax.jws.WebService;


@WebService(endpointInterface = "ws.service.Greeting")
public class GreetingImpl implements Greeting {


    public String sayHello(String name) {//, String surname) {
        return "Hello, Welcome to jax-ws " + name;// + " " + surname;
    }

    public void oneWay(String name) {
        System.out.println(name + "   oneWay *******************************************");
    }

}
