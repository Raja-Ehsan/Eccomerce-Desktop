package com.example.demo4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CartController implements Initializable{
    @FXML
    private Button back_to;
    @FXML
    private TableView <OrderList> product_table;
    @FXML
    private TableColumn <OrderList,Integer> product;
    @FXML
    private TableColumn <OrderList,Integer> quantity;
    @FXML
    private TableColumn <OrderList,Integer> price;
    @FXML
    private TableColumn <OrderList,String> manufacturer;
    ObservableList<OrderList> productSearchObservableList = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getconnection();

        String orderviewQuery = "Select order_id,prod_name,price,category.name from customer join order_ using(customer_id) join order_product using(order_id) join product using (product_id) join category using (category_id) where customer.username=\"Ehsan_Riaz\";";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery((orderviewQuery));
            while (queryResult.next()) {
                Integer queryproduct = queryResult.getInt("order_id");
                String queryquantity = queryResult.getString("prod_name");
                Integer queryprice = queryResult.getInt("price");
                String querymanufacturer = queryResult.getString("category.name");

                productSearchObservableList.add(new OrderList(queryproduct, queryquantity, queryprice, querymanufacturer));
            }

            product.setCellValueFactory(new PropertyValueFactory("order_id"));
            quantity.setCellValueFactory(new PropertyValueFactory("prod_name"));
            price.setCellValueFactory(new PropertyValueFactory("price"));
            manufacturer.setCellValueFactory(new PropertyValueFactory("category.name"));

            product_table.setItems(productSearchObservableList);

        } catch (SQLException e) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }

    public void back_to_main(ActionEvent actionEvent) {

        try{
            Stage stage1 = (Stage) back_to.getScene().getWindow();
            stage1.close();
            FXMLLoader fxmlLoader = new FXMLLoader(EazyShop.class.getResource("Home.fxml"));
            Stage homeStage = new Stage();
            homeStage.initStyle(StageStyle.UNDECORATED);
            homeStage.setScene(new Scene(fxmlLoader.load(), 766, 623));
            homeStage.show();
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
}
