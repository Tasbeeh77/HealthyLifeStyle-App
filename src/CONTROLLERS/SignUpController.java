package CONTROLLERS;

import CONNECTION.sql_connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Window;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;


public class SignUpController extends sql_connection {

    @FXML
    private GridPane signup;

    @FXML
    private ToggleGroup group;

    @FXML
    private TextField Name;

    @FXML
    private TextField Email;

    @FXML
    private PasswordField pass;

    @FXML
    private PasswordField passconf;

    @FXML
    private DatePicker date;

    @FXML
    private Text txterror;

    @FXML
    private ToggleGroup gender;

    @FXML
    private Button signUp2;


    @FXML
    void signinForm(ActionEvent event) throws IOException {

        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../FXML/secondPage.fxml"));
        GridPane pane = Loader.load();
        signup.getChildren().addAll(pane);
    }

    public boolean signUpCheck()
    {
            //if Empty

        if(Name.getText().isEmpty()||Email.getText().isEmpty()||pass.getText().isEmpty()||passconf.getText().isEmpty()||
                date.getValue() == null) {
            txterror.setText("\tAll Fields Must be Filled");
            return false;
        }

            // check the length of the password

        if (pass.getText().length()<5){
            txterror.setText("The password must be at least 5 characters");
            return false;}

            //check if password and confirm password not equal

        if(!(pass.getText().equals(passconf.getText()))) {
            txterror.setText("\tThe passwords not Matching");
            return false;
        }

        else
            return true;

    }

    public static int x =0;

    @FXML
    void SignUp_into_Profile(ActionEvent event) throws IOException, SQLException {

        Window window = signUp2.getScene().getWindow();
           if(!signUpCheck())
           {
               signUpCheck();
               txterror.setFill(Color.RED);
           }

           else{
        try {
            Insert_data(Name.getText(), Email.getText(), pass.getText(), date.getValue(),
                        group.getSelectedToggle().toString());
            showAlert(Alert.AlertType.CONFIRMATION, window, "Form Success!", "Sign Up Completed");

            FXMLLoader Loader = new FXMLLoader(getClass().getResource("../FXML/GetStarted.fxml"));
            GridPane pane = Loader.load();
            signup.getChildren().addAll(pane);
    
            }catch (SQLException e)
            {
                System.out.println("Wrong sql ex:"+e);
            }
            x = data(Email.getText());

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