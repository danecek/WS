package ws.mtomclientfx;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import ws.mtomserver.ImageServer;

public class MainApp1 extends Application {

    static WritableImage load(String path) throws MalformedURLException {
        URL url = new URL("http://localhost:9999/ws/image?wsdl");
        QName qname = new QName("http://mtomserver.ws/", "ImageServerImplService");

        Service service = Service.create(url, qname);
        ImageServer imageServer = service.getPort(ImageServer.class);

        BufferedImage image = (BufferedImage) imageServer.downloadImage(path);
        return SwingFXUtils.toFXImage(image, null);

    }

    @Override
    public void start(final Stage stage) {
        stage.setTitle("Load Picture");
        final ScrollPane sp = new ScrollPane();
        final FileChooser fileChooser = new FileChooser();

        final Button openButton = new Button("Open a Picture...");

        openButton.setOnAction(
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                File file = fileChooser.showOpenDialog(stage);
                if (file != null) {
                    try {
                        Image roses = load(file.getPath());

                        sp.setContent(new ImageView(roses));
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(MainApp1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(openButton, sp);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));
        stage.setScene(new Scene(rootGroup));
        stage.show();
    }

    public static void main(String[] args) {
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        Application.launch(args);
    }


}
