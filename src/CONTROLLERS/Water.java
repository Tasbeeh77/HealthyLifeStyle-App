package CONTROLLERS;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.sql.SQLException;

public class Water {

    @FXML
    private GridPane water;

    secondPageController obj1 = new secondPageController();
    SignUpController obj2 = new SignUpController();
    @FXML
    void backFromWaterToHome(ActionEvent event) throws IOException, SQLException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../FXML/HomePage.fxml"));
        GridPane pane = Loader.load();
        HomePage_Controller obj = ( HomePage_Controller)Loader.getController();
        if (obj1.y == 0)
            obj.user_data(obj2.x);
        else if (obj2.x == 0)
            obj.user_data(obj1.y);
        water.getChildren().addAll(pane);

    }

}