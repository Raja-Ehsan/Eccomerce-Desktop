package com.example.demo4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController<string> implements Initializable  {
    @FXML
    private Button cancelButton;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView easy_shopImageView;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    static String username;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File easy_shopFile=new File("Image/easy_shop.png");
        Image easy_shopImage=new Image(easy_shopFile.toURI().toString());
        easy_shopImageView.setImage(easy_shopImage);
    }

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage =(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void loginButtonOnAction(ActionEvent event){
        if(usernameField.getText().isEmpty() && passwordField.getText().isEmpty()){
            loginMessageLabel.setText("Please Enter Username and Password");
        }
        else{
            validateLogin();
        }

    }

    public void validateLogin(){
        DatabaseConnection connectnow = new DatabaseConnection();
        Connection connectDB = connectnow.getconnection();
        username=usernameField.getText();
        String varifyLogin ="SELECT count(1) FROM customer WHERE username = '"+username+"' AND password = '"+passwordField.getText()+"'";
        try{
            Statement satatement = connectDB.createStatement();
            ResultSet queryResult = satatement.executeQuery(varifyLogin);

            while(queryResult.next()){
                if(queryResult.getInt(1)==1){
                    createHomeForm();
                }
                else{
                    loginMessageLabel.setText("Invalid Login credentials!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    public void createHomeForm()
    {
        try{
            Stage stage1 = (Stage) loginButton.getScene().getWindow();
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


    public void createAccountForm()
    {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(EazyShop.class.getResource("register.fxml"));
            Stage registerstage = new Stage();
            registerstage.initStyle(StageStyle.UNDECORATED);
            registerstage.setScene(new Scene(fxmlLoader.load(), 670, 700));
            registerstage.show();
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }

}

