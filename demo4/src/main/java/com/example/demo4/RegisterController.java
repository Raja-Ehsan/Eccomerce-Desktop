package com.example.demo4;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;


public class RegisterController implements Initializable{

    @FXML
    private Button closeButton;
    @FXML
    private Button registerButton;
    @FXML
    private TextField setpasswordField;
    @FXML
    private TextField confirmpasswordField;
    @FXML
    private Label successfull;
    @FXML
    private Label passwordn;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField,phonetextfield,zipcodeTextfield,stateTextfield,cityTextfield;
    @FXML
    private Hyperlink loginLink;

    public void initialize(URL url, ResourceBundle resourceBundle)
    {    }
    public void closebuttonaction(ActionEvent event) {
        Stage stage= (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void registerbuttononaction(ActionEvent event)
    {
        if(!firstnameTextField.getText().isBlank() && !lastnameTextField.getText().isBlank() && !usernameTextField.getText().isBlank()&& !setpasswordField.getText().isBlank() && !confirmpasswordField.getText().isBlank()) {
            if (setpasswordField.getText().equals(confirmpasswordField.getText())) {
                registeruser();
                passwordn.setText("");
            } else {
                passwordn.setText("Password does not match");
                successfull.setText("");
            }
        }
        else
        {
            passwordn.setText("Please input all fields");
        }
    }
    public void registeruser()
    {
        DatabaseConnection conectNow= new DatabaseConnection();
        Connection connectDB = conectNow.getconnection();

        String firstname= firstnameTextField.getText();
        String lastname= lastnameTextField.getText();
        String username = usernameTextField.getText();
        String password = setpasswordField.getText();
        String zipcode = zipcodeTextfield.getText();
        String state = stateTextfield.getText();
        String city = cityTextfield.getText();
        String phone = phonetextfield.getText();

        String locationField = "Insert ignore into location(zipcode,state,city) Values("+zipcode+",'"+state+"','"+city+"');";
        String insertField = "Insert into customer(first_name,last_name,username,password,phone_no,zipcode) Values('";
        String insertvalues= firstname +"','"+ lastname + "','"+ username+"','"+ password +"','"+ phone +"',"+zipcode+");";
        String inserttoregister = insertField + insertvalues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(locationField);
            statement.executeUpdate(inserttoregister);

            successfull.setText("User has been succesfully registered");
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
    }
    }

    public void goToLogin(ActionEvent actionEvent) {
        {
            try{
                Stage stage1 = (Stage) loginLink.getScene().getWindow();
                stage1.close();
                EazyShop mainObj=new EazyShop();
                Stage stage= new Stage();
                mainObj.start(stage);
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
    }
}
