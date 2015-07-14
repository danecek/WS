package ws.service;

import javax.jws.WebService;

@WebService(endpointInterface = "ws.service.GenPoint")
public class GreetingImpl implements GenPoint {

    public String sayHello(String name) {//, String surname) {
        return "Hello, Welcom to jax-ws " + name;// + " " + surname;
    }

    public Point createPoint(String x, String y) {
        return new Point(Integer.parseInt(x), Integer.parseInt(y));
    }

    public void oneWay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
