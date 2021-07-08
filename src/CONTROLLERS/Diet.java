package CONTROLLERS;
import CONNECTION.sql_connection;
import Model.diet;
import Model.diet;
import Model.table;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXML;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Diet extends sql_connection implements Initializable {

    @FXML
    private GridPane diet;

    @FXML
    private TableView<diet> dietTable;

    @FXML
    private TableColumn<diet, String> week;

    @FXML
    private TableColumn<diet, String> breakfast;

    @FXML
    private TableColumn<diet, String> lunch;

    @FXML
    private TableColumn<diet, String> dinner;

    secondPageController obj1 = new secondPageController();
    SignUpController obj2 = new SignUpController();
    @FXML
    void BackFromDietToHome(ActionEvent event) throws IOException, SQLException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../FXML/HomePage.fxml"));
        GridPane pane = Loader.load();
        HomePage_Controller obj = ( HomePage_Controller)Loader.getController();
        if (obj1.y == 0)
            obj.user_data(obj2.x);
        else if (obj2.x == 0)
            obj.user_data(obj1.y);
        diet.getChildren().addAll(pane);
    }

    void show() throws SQLException {
        show_diet();
        dietTable.setItems(list1);
        week.setCellValueFactory(new PropertyValueFactory<>("week"));
        breakfast.setCellValueFactory(new PropertyValueFactory<>("breakfast"));
        lunch.setCellValueFactory(new PropertyValueFactory<>("lunch"));
        dinner.setCellValueFactory(new PropertyValueFactory<>("dinner"));


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            show();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
