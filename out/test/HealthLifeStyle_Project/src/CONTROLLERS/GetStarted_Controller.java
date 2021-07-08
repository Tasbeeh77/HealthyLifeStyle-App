package CONTROLLERS;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXML;
import java.io.IOException;

public class GetStarted_Controller {


    @FXML
    private GridPane start;

    @FXML
    void GetStarted(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../FXML/After_SignUp.fxml"));
        GridPane pane = Loader.load();
        start.getChildren().addAll(pane);
    }
}
