package CEMS.src.application;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.net.URL;

public class ViewBuilder {
    public static Pane view;

    public static Pane newScreen(String fxmlFile) {

        try {
            URL fxmlURL = Main.class.getResource(fxmlFile + ".fxml");
            if (fxmlURL == null) {
                throw new java.io.FileNotFoundException("FXML file can't be found");
            }
            else
                view = new FXMLLoader().load(fxmlURL);
        }

        catch (Exception e) {
            System.out.println("buildView method cannot find the referenced FXML file");
        }

        return view;
    }
}
