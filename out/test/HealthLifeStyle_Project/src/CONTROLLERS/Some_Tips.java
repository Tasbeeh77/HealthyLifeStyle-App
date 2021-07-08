package CONTROLLERS;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.sql.SQLException;


public class Some_Tips {

    @FXML
    private GridPane someTips;

    @FXML
    private ScrollPane Lose_tips;

    @FXML
    private ScrollPane gain_tips1;

    @FXML
    private ScrollPane Stay_tips;

    secondPageController obj1 = new secondPageController();
    SignUpController obj2 = new SignUpController();
    @FXML
    void BackFromSomeTipsToHome(ActionEvent event) throws IOException, SQLException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../FXML/HomePage.fxml"));
        GridPane pane = Loader.load();
        HomePage_Controller obj = ( HomePage_Controller)Loader.getController();
        if (obj1.y == 0)
            obj.user_data(obj2.x);
        else if (obj2.x == 0)
            obj.user_data(obj1.y);
        someTips.getChildren().addAll(pane);
    }

    public void Tips_visible (){

        Lose_tips.setVisible(false);
        gain_tips1.setVisible(false);
        Stay_tips.setVisible(false);
    }


    @FXML
    void BackToTipsFirst1(ActionEvent event) {
      Lose_tips.setVisible(false);
    }

    @FXML
    void BackToTipsFirst2(ActionEvent event) { gain_tips1.setVisible(false);}

    @FXML
    void BackToTipsFirst3(ActionEvent event) { Stay_tips.setVisible(false); }



    @FXML
    void TipsToGainWeight(ActionEvent event) {
        gain_tips1.setVisible(true);
    }

    @FXML
    void TipsToLooseWeight(ActionEvent event) {
        Lose_tips.setVisible(true);
    }

    @FXML
    void TipsToStayHealthy(ActionEvent event) {
        Stay_tips.setVisible(true);
    }

}
