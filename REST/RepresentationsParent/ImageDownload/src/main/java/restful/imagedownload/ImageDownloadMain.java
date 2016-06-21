/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.imagedownload;

import com.sun.net.httpserver.HttpServer;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.activation.DataSource;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.server.ResourceConfig;
import restful.tools.Tools;

/**
 *
 * @author danecek
 */
public class ImageDownloadMain extends JFrame {

    private final HttpServer server;

    static Image readByDataSource(WebTarget imageDownloadTarget) throws IOException {
        DataSource image = imageDownloadTarget.request(MediaType.APPLICATION_ATOM_XML).get(DataSource.class);
        return ImageIO.read(image.getInputStream());
    }

    static Image readByByteArray(WebTarget imageDownloadTarget) throws IOException {
        byte[] image = imageDownloadTarget.request(MediaType.WILDCARD_TYPE).get(byte[].class);
        return ImageIO.read(new ByteArrayInputStream(image));
    }

    public ImageDownloadMain() throws HeadlessException, IOException {
        super("Elefant");
        server = Tools.startJdkHttpServer(new ResourceConfig(ImageDownloadResource.class));
        WebTarget imageDownloadTarget = Tools.myAppTarget().path("imagedownload").path("Java8.jpg");
        add(new JLabel(new ImageIcon(readByDataSource(imageDownloadTarget))), BorderLayout.NORTH);
        add(new JLabel(new ImageIcon(readByByteArray(imageDownloadTarget))), BorderLayout.SOUTH);
        pack();
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                ImageDownloadMain.this.dispose();
                server.stop(1);

            }

        });
        this.setLocation(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) throws HeadlessException, IOException {
        new ImageDownloadMain();
    }
}
