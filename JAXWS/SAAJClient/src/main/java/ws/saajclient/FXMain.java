/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.saajclient;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.soap.SOAPException;

/**
 *
 * @author danecek
 */
public class FXMain extends Application {
    
    class Length extends Text {

        @Override
        public double prefWidth(double height) {
            return 130;
        }
        
    }

    @Override
    public void start(final Stage primaryStage) {
        Button btn = new Button();
        btn.setAlignment(Pos.BASELINE_RIGHT);
        final Text fileLength = new Length();
        btn.setText("Choose file");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    FileChooser fc = new FileChooser();
                    File f = fc.showOpenDialog(primaryStage);
                    fileLength.setText(FileLength.instance.textLength(f));
                } catch (SOAPException ex) {
                    Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        GridPane root = new GridPane();
        root.setGridLinesVisible(true);
        root.setPadding(new Insets(10));
        root.setVgap(10);
        root.setHgap(10);
        root.add(new Label("File length:"), 0, 0);
        root.setAlignment(Pos.CENTER);

        root.add(fileLength, 1, 0);

        root.add(btn, 0, 1, 3, 1);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
