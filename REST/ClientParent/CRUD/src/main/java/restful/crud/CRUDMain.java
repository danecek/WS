/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.crud;

import com.sun.net.httpserver.HttpServer;
import java.awt.HeadlessException;
import java.io.IOException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.glassfish.jersey.server.ResourceConfig;
import restful.tools.Tools;

/**
 *
 * @author danecek
 */
public class CRUDMain {

    public static HttpServer startServer() {
        ResourceConfig rc = Tools.resConf(CRUDResource.class);
//        Map<String, Object> proMap = new HashMap();
//        proMap.put(ServerProperties.TRACING, true);
//        rc.property(ServerProperties.TRACING, "ALL");
        return Tools.startJdkHttpServer(rc);
    }

    public static void main(String[] args) throws HeadlessException, IOException {
        HttpServer server = startServer();
        try {
            Client client = ClientBuilder.newClient();
            //    client.register(new LoggingFilter());
            WebTarget restAppTarget = client.target(Tools.restAppUriBuilder);
            WebTarget collectionTarget = restAppTarget.path("crud");
            DAO dao = new DAO(collectionTarget);
            System.out.println(dao.readAll2());
            System.out.println(dao.read(2));
            System.out.println("deleted: " + dao.delete(2));
            System.out.println(dao.readAll2());
            dao.create(new Person(3, "Tom"));
            dao.create(new Person(3, "Jerry"));
            System.out.println(dao.readAll2());
            System.out.println("deleted: " + dao.delete(2));
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            server.stop(1);
        }

    }
}
