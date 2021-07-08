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
import java.sql.SQLException;

public class After_SignUp_Controller extends sql_connection  {

    @FXML
    private GridPane BMI;

    @FXML
    private TextField weight;

    @FXML
    private TextField height;

    @FXML
    private ListView<?> bmi_res;

    @FXML
    private Text res;

    @FXML
    private Button start;

    @FXML
    private Text restxt;

    @FXML
    private Text advise_txt;
    @FXML
    private Text calc;
    @FXML
    private TextField AGE;
    @FXML
    private ComboBox<String> active;

    @FXML
    private ToggleGroup gender;

    int BMR;
    int cal;
    String calorie;
    String result;

                                     // Check BMI result to identify the case of user

    public void Check_BMI(double Result)
    {
        if(Result <18.5)
        {
            bmi_res.setStyle("-fx-background-color : #ff9900");
            restxt.setText("You are Underweight");
            restxt.setFill(Color.ORANGE);
            advise_txt.setText("You need to gain weight in order to be healthy. press the following button to " +
                    "start your healthy life journey");
        }
        if(Result >=18.5 && Result <=25)
        {
            bmi_res.setStyle("-fx-background-color :  #00cc00");
            restxt.setText("Your weight is Normal");
            restxt.setFill(Color.GREEN);
            advise_txt.setText("You don't need to gain or lose weight in order to be healthy. press the following " +
                    "button to start your healthy life journey");
        }
        if(Result >25 && Result <=30)
        {
            bmi_res.setStyle("-fx-background-color :  #ff794d");
            restxt.setText("You are Overweight");
            restxt.setFill(Color.rgb(255, 121, 77));
            advise_txt.setText("You need to Lose weight in order to be healthy. press the following button to " +
                    "start your healthy life journey");
        }
        if(Result >30)
        {
            bmi_res.setStyle("-fx-background-color :  #ff0000");
            restxt.setText("You are Obese");
            restxt.setFill(Color.RED);
         advise_txt.setText("You necessary need to Lose weight in order to be healthy. press the following button to " +
                    "start your healthy life journey");
        }
    }

                                            // calculate user's Body Mass Index

    @FXML
    void Calculate_BMI(ActionEvent event) {

        res.setText(String.format("%.2f",Double.parseDouble(weight.getText())
        / Math.pow(Double.parseDouble(height.getText()), 2.0)));
        result=res.getText();

         Check_BMI(Double.parseDouble(result));
         start.setVisible(true);
         calc.setText("Your BMI : ");
    }

                                          // Calculate user's BMR

    public int Calculate_BMR()
    {
       String Gender = gender.getSelectedToggle().toString();
        if (Gender.equals("Male"))
        {
            BMR =  (int) (66 + (6.23 * Double.parseDouble(weight.getText())) +
                    (12.7 * Double.parseDouble(height.getText())) - (6.8 * Integer.parseInt(AGE.getText())));
        }
        else
        {
            BMR = (int) (665 + (4.35 * Double.parseDouble(weight.getText())) +
                    (4.7 * Double.parseDouble(height.getText())) - (4.7 *Integer.parseInt(AGE.getText())));
        }

        return BMR;

    }

                                           // Calculate user's Daily required calories

    @FXML
    void Calculate_Calories(ActionEvent event) {
       String val = String.valueOf(active.getValue());
       int resul = Calculate_BMR();
        if (val.equals("None"))
        {
            cal =  (int)(resul * 1.2);
        }
        else if (val.equals("Light"))
        {
            cal =  (int)(resul * 1.375);
        }
        else if (val.equals("moderately"))
        {
            cal =  (int)(resul * 1.55);
        }
        else if (val.equals("intensely"))
        {
            cal =  (int)(resul * 1.725);
        }
        res.setText(String.valueOf(cal));
        calorie =res.getText() ;
        calc.setText("Calories : ");
    }

                                          // Moving to HomePage

    @FXML
    void Start_HomePage(ActionEvent event) throws IOException , SQLException {
        Window window = start.getScene().getWindow();
        if (weight.getText().isEmpty()||height.getText().isEmpty()||AGE.getText().isEmpty()||active.getValue().isEmpty())
        {
            showAlert(Alert.AlertType.ERROR, window, "Form Error!", "All fields Must be filled");
        }
        else {
            BMI_Insert(weight.getText(), height.getText(), AGE.getText(),result,calorie);
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("../FXML/HomePage.fxml"));
            GridPane pane = Loader.load();
            SignUpController object = new SignUpController();
            HomePage_Controller obj = ( HomePage_Controller)Loader.getController();
            obj.user_data(object.x);
            BMI.getChildren().addAll(pane);
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
