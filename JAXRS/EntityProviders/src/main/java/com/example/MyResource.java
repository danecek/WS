package com.example;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("resource")
public class MyResource {

    public static final MyBean MY_BEAN = new MyBean("Hello World!", 42);

    @GET
    @Produces("application/xml")
    public MyBean getMyBean() {
        return MY_BEAN;
    }

    @POST
    @Consumes("application/xml")
    public String postMyBean(MyBean myBean) {
        return myBean.anyString;
    }
}
