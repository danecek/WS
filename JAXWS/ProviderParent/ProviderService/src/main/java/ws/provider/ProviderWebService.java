/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.provider;

import javax.xml.ws.Provider;
import javax.xml.ws.WebServiceProvider;
import javax.annotation.Resource;
import javax.xml.transform.Source;
import javax.xml.ws.WebServiceContext;

/**
 *
 * @author danecek
 */
@WebServiceProvider
public class ProviderWebService implements Provider<Source> {

    @Resource
    protected WebServiceContext wsContext;

    @Override
    public Source invoke(Source request) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
