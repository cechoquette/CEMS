package CEMS.src.application;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;


public class ViewBuilder {
    public static Pane view;

    public static Pane newScreen(String fxmlFile) {

        try {
                view = new FXMLLoader().load(ViewBuilder.class.getResource("/CEMS/src/resources/fxml/" + fxmlFile + ".fxml"));
        }

        catch (Exception e) {
            System.out.println("buildView method cannot find the referenced FXML file");
        }
        return view;
    }
}
