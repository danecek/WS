package ws.mtomclient;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import ws.mtomserver.ImageServer;

public class ImageClient extends JFrame {

    public static void main(String[] args) {
               System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");

        new ImageClient();
    }

    static Image loadImage(String path) throws MalformedURLException {

        URL url = new URL("http://localhost:9999/ws/image?wsdl");
        QName qname = new QName("http://mtomserver.ws/", "ImageServerImplService");

        Service service = Service.create(url, qname);
        ImageServer imageServer = service.getPort(ImageServer.class);

        Image image = imageServer.downloadImage(path);

        return image;

    }
    
    class ImPanekl extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, image.getWidth(null), image.getHeight(null), null);//To change body of generated methods, choose Tools | Templates.
        }
        
        private Image image;

        /**
         * @return the image
         */
        public Image getImage() {
            return image;
        }

        /**
         * @param image the image to set
         */
        public void setImage(Image image) {
            this.image = image;
        }
    }
    
    public ImageClient() throws HeadlessException {
        setSize(300, 300);
        JPanel p = new JPanel();
        add(p);
        add(new JButton(new AbstractAction("choose") {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int returnVal = chooser.showOpenDialog(ImageClient.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    try {
                        Image i = loadImage(chooser.getSelectedFile().getPath());
                        p.getGraphics().drawImage(i, 100, 100, null);

                    } catch (MalformedURLException ex) {
                        Logger.getLogger(ImageClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }), BorderLayout.SOUTH);
        setVisible(true);
    }
}
