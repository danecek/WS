package ws.mtomserver;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

//Service Implementation Bean
@MTOM
@WebService(endpointInterface = "ws.mtomserver.ImageServer")
public class ImageServerImpl implements ImageServer {

    @Override
    public Image downloadImage(String path) {

        try {
            File image = new File(path);
            return ImageIO.read(new FileImageInputStream(image));

        } catch (IOException e) {

            e.printStackTrace();
            return null;

        }
    }

    @Override
    public String uploadImage(Image data) {

        if (data != null) {
            //store somewhere
            return "Upload Successful";
        }

        throw new WebServiceException("Upload Failed!");

    }

}
