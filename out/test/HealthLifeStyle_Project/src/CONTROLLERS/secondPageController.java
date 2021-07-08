package CONTROLLERS;

import CONNECTION.sql_connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;


public class secondPageController extends sql_connection {


    @FXML
    private GridPane signinPage;

    @FXML
    private TextField mail;

    @FXML
    private PasswordField pas;

    @FXML
    private Button signIn;


    @FXML
    void SignUpPage(ActionEvent event) throws IOException {

        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../FXML/SignUp.fxml"));
        GridPane pane = Loader.load();
        signinPage.getChildren().addAll(pane);
    }

    static int y =0;
    @FXML
    void SignIn_Into_Profile(ActionEvent event) throws IOException, SQLException {
        Window window = signIn.getScene().getWindow();
        boolean x = select_sign_in(mail.getText(),pas.getText());
        y = data(mail.getText());
        if (x){
            try {
                FXMLLoader Loader = new FXMLLoader(getClass().getResource("../FXML/HomePage.fxml"));
                GridPane pane = Loader.load();
                HomePage_Controller obj = ( HomePage_Controller)Loader.getController();
                obj.user_data(y);
                signinPage.getChildren().addAll(pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            showAlert(Alert.AlertType.ERROR, window, "Form Error!", "Wrong Email or Password!");
        }
    }

    private static void showAlert(Alert.AlertType alertType, Window window, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(window);
        alert.show();
    }

}
