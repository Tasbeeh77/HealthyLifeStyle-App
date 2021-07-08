package CONTROLLERS;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import java.io.IOException;

public class Controller {

    @FXML
    private GridPane page1;


    @FXML
    void HomeLogin(ActionEvent event)  throws IOException {

            FXMLLoader Loader = new FXMLLoader(getClass().getResource("../FXML/secondPage.fxml"));
            GridPane pane = Loader.load();
            page1.getChildren().addAll(pane);

    }

    @FXML
    void HomeRegister(ActionEvent event) throws IOException {

        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../FXML/SignUp.fxml"));
        GridPane pane = Loader.load();
        page1.getChildren().addAll(pane);

    }
}
