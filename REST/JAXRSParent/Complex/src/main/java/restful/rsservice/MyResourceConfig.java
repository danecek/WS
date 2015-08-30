/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.rsservice;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

/**
 *
 * @author danecek
 */
public class MyResourceConfig extends ResourceConfig {//Application {

    public MyResourceConfig() {
        super(MyResource.class);//, MyWriterInterceptor.class, MyFilter.class, MyReaderInterceptor.class);
        //property(ServerProperties.PROVIDER_PACKAGES, new String[]{"jaxb.rsservice"});

       // packages("jaxb.rsservice");
    }

}
