package CONTROLLERS;

import CONNECTION.sql_connection;
import Model.table;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Window;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class Calories_controller extends sql_connection {

    @FXML
    private GridPane Calories_search;

    @FXML
    private TextField search;

    @FXML
    private TableView<table> table_view;

    @FXML
    private TableColumn<table, String> food_name;

    @FXML
    private TableColumn<table, Double> amount;

    @FXML
    private TableColumn<table, String> unit;

    @FXML
    private TableColumn<table, Integer> food_cal;

    @FXML
    private AnchorPane insetData;

    @FXML
    private TextField foName;

    @FXML
    private TextField foAmount;

    @FXML
    private TextField FoUnit;

    @FXML
    private TextField FoCalories;

    @FXML
    private Button insertDataToCaloriesTable;

    secondPageController obj1 = new secondPageController();
    SignUpController obj2 = new SignUpController();
    @FXML
    void BackFromCaloriesToHome(ActionEvent event) throws IOException, SQLException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../FXML/HomePage.fxml"));
        GridPane pane = Loader.load();
        HomePage_Controller obj = ( HomePage_Controller)Loader.getController();
        if (obj1.y == 0)
            obj.user_data(obj2.x);
        else if (obj2.x == 0)
            obj.user_data(obj1.y);
        Calories_search.getChildren().addAll(pane);
    }

    @FXML
    void BackToTable(ActionEvent event) {

        insetData.setVisible(false);
    }


    @FXML
    void InsertData(ActionEvent event) {

        insetData.setVisible(true);


    }
    @FXML
    void insertDataToCaloriesTable(ActionEvent event) throws SQLException {


        if(foName.getText().isEmpty()||foAmount.getText().isEmpty()||FoUnit.getText().isEmpty()||
                FoCalories.getText().isEmpty())
        {

            System.out.println("All fields Must be filled");        }
        else
        {
        Insert_Food_data(foName.getText(),Double.parseDouble(foAmount.getText()),FoUnit.getText(),
                Integer.parseInt(FoCalories.getText()));
            System.out.println("success");
        }

    }


    @FXML
    void Show_all(ActionEvent event) throws SQLException {
        table_view.setVisible(true);
       show_table();
       table_view.setItems(list);
       food_name.setCellValueFactory(new PropertyValueFactory<>("food_name"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        unit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        food_cal.setCellValueFactory(new PropertyValueFactory<>("calories"));


    }


    @FXML
    void Search_in_Table(ActionEvent event) throws SQLException {

        table_view.setVisible(true);
        show_food(search.getText());
        table_view.setItems(list);
        food_name.setCellValueFactory(new PropertyValueFactory<>("food_name"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        unit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        food_cal.setCellValueFactory(new PropertyValueFactory<>("calories"));

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

