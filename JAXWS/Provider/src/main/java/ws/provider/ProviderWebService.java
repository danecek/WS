/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.provider;

import javax.xml.ws.Provider;
import javax.xml.ws.WebServiceProvider;
import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;

/**
 *
 * @author danecek
 */
@WebServiceProvider
public class ProviderWebService implements Provider<MyMessage> {

    @Override
    public MyMessage invoke(MyMessage request) {
        System.out.println(request);
        return request;
    }

    @Resource
    protected WebServiceContext wsContext;

}
