package com.example.demo4;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManufacturersController implements Initializable{
    @FXML
    private TableView <OrderList> producttable;
    @FXML
    private TableColumn <OrderList,Integer> Order_idTC;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getconnection();

        String orderviewQuery = "Select Order_id from product1;";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery((orderviewQuery));
            while (queryResult.next()) {
                Order_idTC.setCellValueFactory(new PropertyValueFactory("Order_id"));

            }
        } catch (SQLException e) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }
}
