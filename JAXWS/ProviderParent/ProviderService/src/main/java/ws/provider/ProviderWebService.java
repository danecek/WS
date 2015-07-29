/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.provider;

import java.io.StringReader;
import javax.xml.ws.Provider;
import javax.xml.ws.WebServiceProvider;
import javax.annotation.Resource;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.WebServiceContext;

/**
 *
 * @author danecek
 */
@WebServiceProvider(portName = "pn") 
public class ProviderWebService implements Provider<Source> {

    @Resource
    protected WebServiceContext wsContext;

    @Override
    public Source invoke(Source request) {
        return new StreamSource(new StringReader("<return>Ahoj</return>"));
    }

}
