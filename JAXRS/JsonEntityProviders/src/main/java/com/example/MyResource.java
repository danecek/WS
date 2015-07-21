package com.example;

import javax.ws.rs.*;

@Path("resource")
public class MyResource {

    public static final MyBean MY_BEAN = new MyBean("Hello World!", 2015);

    @GET
    @Produces("application/json")
    public MyBean getMyBean() {
        return MY_BEAN;
    }

    @POST
    @Consumes("application/json")
    public String postMyBean(MyBean myBean) {
        return myBean.anyString;
    }
}
