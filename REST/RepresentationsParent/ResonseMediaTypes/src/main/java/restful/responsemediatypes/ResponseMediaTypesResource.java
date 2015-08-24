/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.responsemediatypes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

@Path("myresource")

public class ResponseMediaTypesResource {

    public static final String XML_ROOT_BEAN = "XML_ROOT_BEAN";
    public static final String INT = "INT";
    public static final String FILE = "FILE";
    public static final String FILE_INPUT_STREAM = "FILE_INPUT_STREAM";
    public static final String BYTE_ARRAY = "BYTE_ARRAY";
    public static final String STRING = "STRING";
    public static final String BOOLEAN = "BOOLEAN";
    public static final String INPUT_STREAM = "INPUT_STREAM";
    public static final String BY_PRODUCES = "BY_PRODUCES";
    public static final String BY_TYPE = "BY_TYPE";
        public static final String STRING_AS_IMAGE = "STRING_AS_IMAGE";

    @GET
    @Path(XML_ROOT_BEAN)
    public Response getBean() {
        return Response.ok().entity(new Bean()).build();
    }

    @GET
    @Path(INT)
    public Response getInt() {
        return Response.ok().entity(1).build();
    }

    @GET
    @Path(FILE)
    public Response getFile() {
        return Response.ok().entity(new File("file.txt")).build();
    }

    @GET
    @Path(FILE_INPUT_STREAM)
    public Response getInputStream() {
        try {
            return Response.ok().entity(new FileInputStream("file.txt")).build();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ResponseMediaTypesResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @GET
    @Path(BYTE_ARRAY)
    public Response getByteArray() {
        return Response.ok("XYZ".getBytes()).build();
    }

    @GET
    @Path(STRING)
    public Response getString() {
        return Response.ok("XYZ").build();
    }

    @GET
    @Path(BOOLEAN)
    public Response getBoolean() {
        return Response.ok(true).build();
    }

    @GET
    @Path(BY_PRODUCES)
    @Produces(MediaType.TEXT_PLAIN)
    public Response getStringByProduces() {
        return Response.ok("XYZ").build();
    }

    @GET
    @Path(BY_TYPE)
    public Response getStringByType() {
        return Response.ok("XYZ", MediaType.TEXT_PLAIN_TYPE).build();
    }

    @GET
    @Path(STRING_AS_IMAGE)
    @Produces("image/*")
    public Response getStringAsImage() {
        return Response.ok().entity("XYZ").build();
    }

}

@XmlRootElement
class Bean {

    public int x = 1;
}
