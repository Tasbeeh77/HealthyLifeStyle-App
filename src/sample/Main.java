package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {
public static Stage primary;
    @Override
    public void start(Stage primaryStage){
        primary = primaryStage;
        try {

            FXMLLoader Loader = new FXMLLoader(getClass().getResource("../FXML/sample.fxml"));
            GridPane pane = Loader.load();
            primaryStage.setTitle("Healthy Lifestyle APP");
            primaryStage.setScene(new Scene( pane , 779 , 535 ));
            primaryStage.setResizable(false);
            primaryStage.show();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
