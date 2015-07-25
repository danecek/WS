package com.wshelloworldclient;

import ws.wshelloworld.HelloService;
import ws.wshelloworld.HelloServiceService;

public class Main {

    public static void main(String[] args) {
        HelloServiceService service = new HelloServiceService();
        HelloService port = service.getHelloServicePort();
        System.out.println(port.hello("John"));
    }
}
