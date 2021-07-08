package CONTROLLERS;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import java.io.IOException;
import java.sql.SQLException;


public class Workout {
    @FXML
    private GridPane workout;

    @FXML
    private AnchorPane weekOnePage;

    @FXML
    private AnchorPane weekTwoPage;

    @FXML
    private AnchorPane WeekThreePage;

    @FXML
    private AnchorPane weekFourPage;

    @FXML
    private ImageView Workout_Img;

    @FXML
    private Text workoutText;

    @FXML
    private Hyperlink back;

    @FXML
    private Hyperlink next;
    @FXML
    private Hyperlink back1;

    @FXML
    private Hyperlink next1;  @FXML
    private Hyperlink back2;

    @FXML
    private Hyperlink next2;  @FXML
    private Hyperlink back3;

    @FXML
    private Hyperlink next3;

    int i =0;


    public void Workout_visible (){

        weekOnePage.setVisible(false);
        weekTwoPage.setVisible(false);
        WeekThreePage.setVisible(false);
        weekFourPage.setVisible(false);
    }


    String [] s = {"file:///H:/HealthLifeStyle_Project/src/FXML/projectphotos/jump.jpg" ,
            "file:///H:/HealthLifeStyle_Project/src/FXML/projectphotos/pushup.jpg" ,
            "file:///H:/HealthLifeStyle_Project/src/FXML/projectphotos/squat.jpg" ,
            "file:///H:/HealthLifeStyle_Project/src/FXML/projectphotos/lunge.jpg" ,
            "file:///H:/HealthLifeStyle_Project/src/FXML/projectphotos/situp.jpg" ,
            "file:///H:/HealthLifeStyle_Project/src/FXML/projectphotos/strech.jpg" };

    String [] txt = {"20 Jumping Jacks","10 Push Ups","15 squat","20 lunges" ,"10 sit up" , "Rest and Stretch"};



        @FXML
        void BackToFirstPage1(ActionEvent event) { weekOnePage.setVisible(false);  }

        @FXML
        void BackToFirstPage2(ActionEvent event) { weekTwoPage.setVisible(false);  }

        @FXML
        void BackToFirstPage3(ActionEvent event) { WeekThreePage.setVisible(false);}

        @FXML
        void BackToFirstPage4(ActionEvent event) { weekFourPage.setVisible(false); }


    secondPageController obj1 = new secondPageController();
    SignUpController obj2 = new SignUpController();
    @FXML
    void BackFromWorkoutToHome(ActionEvent event) throws IOException, SQLException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../FXML/HomePage.fxml"));
        GridPane pane = Loader.load();
        HomePage_Controller obj = ( HomePage_Controller)Loader.getController();
        if (obj1.y == 0)
            obj.user_data(obj2.x);
        else if (obj2.x == 0)
            obj.user_data(obj1.y);
        workout.getChildren().addAll(pane);
    }

       @FXML
       void WEEKONE(ActionEvent event)   { weekOnePage.setVisible(true);  }

       @FXML
       void WEEKTWO(ActionEvent event)   { weekTwoPage.setVisible(true);  }

       @FXML
       void WEEKTHREE(ActionEvent event) { WeekThreePage.setVisible(true);}

       @FXML
       void WEEKFOUR(ActionEvent event)  { weekFourPage.setVisible(true); }


    @FXML
    void Next_Img(ActionEvent event) {
            i++;
        if(i>5)
        {
            next.setDisable(true);
            back.setDisable(false);
            i--;
         }
        else
        {
            Image image = new Image(s[i]);
            Workout_Img.setImage(image);
            workoutText.setText(txt[i]);
        }
    }

    @FXML
    void back_Img(ActionEvent event) {
            i--;
        if(i<0)
       {
        back.setDisable(true);
        next.setDisable(false);
        i++;
       }
        else
       {
           Image image = new Image(s[i]);
           Workout_Img.setImage(image);
           workoutText.setText(txt[i]);
       }
    }
}
