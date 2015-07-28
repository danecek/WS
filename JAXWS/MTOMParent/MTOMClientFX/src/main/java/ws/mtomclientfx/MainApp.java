package ws.mtomclientfx;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
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

public class MainApp extends Application {

    static WritableImage load(String path) throws MalformedURLException {
        URL url = new URL("http://localhost:9999/ws/image?wsdl");
        QName qname = new QName("http://mtomserver.ws/", "ImageServerImplService");

        Service service = Service.create(url, qname);
        ImageServer imageServer = service.getPort(ImageServer.class);

        BufferedImage image = imageServer.downloadImage(path);
        return SwingFXUtils.toFXImage(image, null);

        // return image;
    }

    private final Desktop desktop = Desktop.getDesktop();

    @Override
    public void start(final Stage stage) {
        stage.setTitle("File Chooser Sample");

        final FileChooser fileChooser = new FileChooser();

        final Button openButton = new Button("Open a Picture...");
        // final Button openMultipleButton = new Button("Open Pictures...");

        openButton.setOnAction(
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                File file = fileChooser.showOpenDialog(stage);
                if (file != null) {
                    openFile(file);
                }
            }
        });

        final GridPane inputGridPane = new GridPane();

        GridPane.setConstraints(openButton, 0, 0);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(openButton);

        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));

        stage.setScene(new Scene(rootGroup));
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private void openFile(File file) {

        try {
            Image roses = load(file.getPath());
                //    = new Image(new FileInputStream(file));
            ScrollPane sp = new ScrollPane();
            sp.setContent(new ImageView(roses));
            sp.setHbarPolicy(ScrollBarPolicy.NEVER);
            sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
            Scene secondScene = new Scene(sp, roses.getWidth(), roses.getHeight());

            Stage secondStage = new Stage();
            secondStage.setTitle("Second Stage");
            secondStage.setScene(secondScene);

//                //Set position of second window, related to primary window.
//                secondStage.setX(primaryStage.getX() + 250);
//                secondStage.setY(primaryStage.getY() + 100);
            secondStage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(
                    Level.SEVERE, null, ex
            );
        }
    }
}
