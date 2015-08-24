/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.responsemediatypes;

import com.sun.net.httpserver.HttpServer;
import java.awt.HeadlessException;
import java.io.IOException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;
import static restful.responsemediatypes.ResponseMediaTypesResource.*;
import restful.tools.Tools;

/**
 *
 * @author danecek
 */
public class ResponseMediaTypesMain {

    private static WebTarget myresourceTarget;

    static class MyApplication extends ResourceConfig {

        public MyApplication() {
            super(ResponseMediaTypesResource.class);
            //   register(new LoggingFilter(Logger.getAnonymousLogger(), true));
        }

    }

    static void x(String type) {
        Response r = myresourceTarget.path(type).request().get();
        System.out.printf("%s: %s\n", type, r.getMediaType());
    }

    public static void main(String[] args) throws HeadlessException, IOException {

        HttpServer server = Tools.startJdkHttpServer(new MyApplication());
        try {
            myresourceTarget = Tools.myAppTarget().path("myresource");
            x(INT);
            x(BOOLEAN);
            x(BYTE_ARRAY);
            x(STRING);
            x(FILE);
            x(FILE_INPUT_STREAM);
            x(XML_ROOT_BEAN);

            x(BY_PRODUCES);
            x(BY_TYPE);
            x(STRING_AS_IMAGE);
        } finally {
            server.stop(1);
        }
    }
}
