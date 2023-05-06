package com.example.demo4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminController implements Initializable{
    @FXML
    private TableView <AdminProducts> producttable;
    @FXML
    private TableColumn <AdminProducts,Integer> Order_idTC;
    @FXML
    private TableColumn <AdminProducts,Integer> Customer_idTC;
    @FXML
    private TableColumn <AdminProducts,String> NameTC;
    @FXML
    private TableColumn <AdminProducts,Integer> Product_idTC;
    @FXML
    private TableColumn <AdminProducts,String> PNameTC;
    @FXML
    private TableColumn <AdminProducts,String> PriceTC;
    @FXML
    private TableColumn <AdminProducts,Integer> Category_idTC;
    @FXML
    private TableColumn <AdminProducts,Integer> Manufacturer_idTC;
    @FXML
    private TableColumn <AdminProducts,String> StatusTC;
    @FXML
    private TextField keywordfield;
    @FXML
    private ImageView easy_shop_borderImageView;
    @FXML
    private ImageView borderImageView;

    ObservableList<AdminProducts> productSearchObservableList = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File HarryImage=new File("Image/easy_shop_border.png");
        Image Harry = new Image(HarryImage.toURI().toString());
        easy_shop_borderImageView.setImage(Harry);

        File Rumi=new File("Image/border.png");
        Image rumi = new Image(Rumi.toURI().toString());
        borderImageView.setImage(rumi);

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getconnection();

        String orderviewQuery = "select order_id,customer_id,username,product_id,prod_name,price,category_id,manufacturer_id,status from customer join order_ using (customer_id) join order_product using(order_id) join product using (product_id) join category using (category_id) join manufactured_by using(product_id) join manufacturer using(manufacturer_id);";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery((orderviewQuery));
            while (queryResult.next()) {
                Integer queryOrder_id = queryResult.getInt("order_id");
                Integer queryUser_id = queryResult.getInt("customer_id");
                String queryUsername = queryResult.getString("username");
                Integer queryProduct_id = queryResult.getInt("product_id");
                String queryPName = queryResult.getString("prod_name");
                String queryPrice = queryResult.getString("price");
                Integer queryCategory_id = queryResult.getInt("category_id");
                Integer queryManufacturer_id = queryResult.getInt("manufacturer_id");
                String queryStatus = queryResult.getString("status");

                productSearchObservableList.add(new AdminProducts(queryOrder_id, queryUser_id, queryUsername, queryProduct_id, queryPName, queryPrice,queryCategory_id, queryManufacturer_id, queryStatus));
            }

            Order_idTC.setCellValueFactory(new PropertyValueFactory("order_id"));
            Customer_idTC.setCellValueFactory(new PropertyValueFactory("customer_id"));
            NameTC.setCellValueFactory(new PropertyValueFactory("username"));
            Product_idTC.setCellValueFactory(new PropertyValueFactory("product_id"));

            PNameTC.setCellValueFactory(new PropertyValueFactory("prod_name"));

            PriceTC.setCellValueFactory(new PropertyValueFactory("price"));

            Category_idTC.setCellValueFactory(new PropertyValueFactory("category_id"));
            Manufacturer_idTC.setCellValueFactory(new PropertyValueFactory("manufacturer_id"));
            StatusTC.setCellValueFactory  (new PropertyValueFactory("status"));

            producttable.setItems(productSearchObservableList);

            FilteredList<AdminProducts> filteredData = new FilteredList(productSearchObservableList, b->true);
            keywordfield.textProperty().addListener((observable,oldValue,newValue)->{
                filteredData.setPredicate(productsearch -> {
                    if(newValue.isEmpty() ||  newValue.isBlank() || newValue == null){
                        return true;
                    }
                    String  searchKeyword = newValue.toLowerCase();
                    if(productsearch.getPName().toLowerCase().indexOf(searchKeyword)> -1){
                        return true;
                    }
                    else if (productsearch.getProduct_id().toString().indexOf(searchKeyword)> -1){
                        return true;
                    }

                    else if (productsearch.getName().toLowerCase().indexOf(searchKeyword)> -1){
                        return true;
                    }


                    else if (productsearch.getCategory_id().toString().indexOf(searchKeyword)> -1){
                        return true;
                    }

                    else if (productsearch.getManufacturer_id().toString().indexOf(searchKeyword)> -1){
                        return true;
                    }

                    else if (productsearch.getCustomer_id().toString().indexOf(searchKeyword)> -1){
                        return true;
                    }
                    else if (productsearch.getOrder_id().toString().indexOf(searchKeyword)> -1){
                        return true;
                    }

                    else if (productsearch.getPrice().toLowerCase().indexOf(searchKeyword)> -1){
                        return true;
                    }
                    else if (productsearch.getStatus().toLowerCase().indexOf(searchKeyword)> -1){
                        return true;
                    }
                    else return false;
                });
            });

            SortedList<AdminProducts> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(producttable.comparatorProperty());
            producttable.setItems(sortedData);
        } catch (SQLException e) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }
}
