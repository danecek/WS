/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.asynchelloworld;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

/**
 *
 * @author danecek
 */
@Path("asyncresource")
public class AsyncHelloWorldResource {

    static final Logger LG = Logger.getLogger("org.glassfish.jersey.tracing.general");

    String theUltimateQuestionOfLifeTheUniverseAndEverything() {
        return "42";
    }

    @GET
 //   @Path("async/{echo}")
    public String asyncEcho(@Suspended final AsyncResponse ar) {
        ExecutorService TASK_EXECUTOR = Executors.newCachedThreadPool();
        TASK_EXECUTOR.submit(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (final InterruptedException ex) {
                    ar.cancel();
                }
                ar.resume("hello");
            }
        });
        return "xxx";
    }

//    @GET
//    public AsyncResponse asyncGet(
//            //    ) {   
//            //        LG.log(Level.SEVERE, "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//            //        int i =0; 
//            //        return "OK";// + 5/i;
//            //    }
//            @Suspended final AsyncResponse asyncResponse) {
//
//        LG.log(Level.SEVERE, "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//        try {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    String result = theUltimateQuestionOfLifeTheUniverseAndEverything();
//                    asyncResponse.resume(result);
//                    //      asyncResponse.
//                }
//            }).start();
//        } catch (Exception ex) {
//            LG.log(Level.SEVERE, "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//        }
//        return asyncResponse;
//    }
}
