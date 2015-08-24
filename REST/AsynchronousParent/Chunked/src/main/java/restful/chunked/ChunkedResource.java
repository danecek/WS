/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.chunked;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.glassfish.jersey.server.ChunkedOutput;

@Path("/chunkedresource")
public class ChunkedResource {

    Iterator<String> chunkIt() {
        List<String> ls= new ArrayList<>();
        Collections.addAll(ls, "Hello\r\n", "World\r\n");
        return ls.iterator();
    }

    @GET
    public ChunkedOutput<String> getChunkedResponse() {
        ChunkedOutput<String> chunkedOutput = new ChunkedOutput<>(String.class);
        new Thread() {
            @Override
            public void run() {
                try (ChunkedOutput<String> cho = chunkedOutput) {
                    for (Iterator<String> chunkIt = chunkIt(); chunkIt.hasNext();) {
                        cho.write(chunkIt.next());
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ChunkedResource.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
        return chunkedOutput;
    }
}
