/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.rsservice;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

/**
 *
 * @author danecek
 */
public class MyResources extends ResourceConfig {//Application {

    public MyResources() {
        super(MyResource.class, MyWriterInterceptor.class, MyFilter.class, MyReaderInterceptor.class);
        property(ServerProperties.PROVIDER_PACKAGES, new String[]{"jaxb.rsservice"});
    }

}
