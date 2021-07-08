package CONTROLLERS;

import CONNECTION.sql_connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import java.io.IOException;
import java.sql.SQLException;

public class HomePage_Controller extends sql_connection {

    @FXML
    private GridPane Home;

    @FXML
    private Text user;

    @FXML
    private Text userBmi;

    @FXML
    private Text userWght;

    @FXML
    private Text calo;


    @FXML
    void Calories_Search(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../FXML/Calories.fxml"));
        GridPane pane = Loader.load();
        Home.getChildren().addAll(pane);
    }

    public void user_data(int id) throws SQLException {
        String[] result = result(id);
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
        user.setText(result[0]);
        userBmi.setText(result[1]);
        userWght.setText(result[2]);
        calo.setText(result[3]);
        System.out.println("home");
    }

    @FXML
    void WORKOUT(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../FXML/Workout.fxml"));
        GridPane pane = Loader.load();
        Workout obj = (Workout)Loader.getController();
        obj.Workout_visible();
        Home.getChildren().addAll(pane);
    }
    @FXML
    void DIET(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../FXML/Diet.fxml"));
        GridPane pane = Loader.load();
        Home.getChildren().addAll(pane);
    }

    @FXML
    void WATER(ActionEvent event)  throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../FXML/Water.fxml"));
        GridPane pane = Loader.load();
        Home.getChildren().addAll(pane);

    }

    @FXML
    void Some_Tips(ActionEvent event) throws IOException {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("../FXML/SomeTips.fxml"));
            GridPane pane = Loader.load();
            Some_Tips obj = (Some_Tips)Loader.getController();
            obj.Tips_visible();
            Home.getChildren().addAll(pane);

    }

    @FXML
    void LogOut(ActionEvent event) throws IOException {
        secondPageController obj = new secondPageController();
        obj.y = 0;
        SignUpController obj2 = new SignUpController();
        obj2.x = 0;
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../FXML/sample.fxml"));
        GridPane pane = Loader.load();
        Home.getChildren().addAll(pane);
    }




}
