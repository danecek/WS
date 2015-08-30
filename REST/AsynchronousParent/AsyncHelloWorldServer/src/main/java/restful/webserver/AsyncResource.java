/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.webserver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

@Path("asyncresource")
public class AsyncResource {

//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getSync() {
//        return "sync";
//    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void getAsync(@Suspended final AsyncResponse ar) {

        ExecutorService TASK_EXECUTOR = Executors.newCachedThreadPool();
        TASK_EXECUTOR.submit(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (final InterruptedException ex) {
                    ar.cancel();
                }
                ar.resume("async");
            }
        });
    }
}
