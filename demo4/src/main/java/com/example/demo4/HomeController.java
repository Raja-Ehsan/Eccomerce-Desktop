
package com.example.demo4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private Hyperlink logOutLink;
    @FXML
    private Button homeButton;
    @FXML
    private MenuButton categoryButton;
    @FXML
    private Button manufacturerButton;
    @FXML
    private Button cartButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView borderImageView;
    @FXML
    private ImageView easy_shop_borderImageView;
    @FXML
    private ImageView helmetImageView;
    @FXML
    private ImageView bottleImageView;
    @FXML
    private ImageView oppoImageView;
    @FXML
    private ImageView harry_potterImageView;
    @FXML
    private MenuItem clothingMenu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
       File borderFile=new File("Image/border.png");
        Image borderImage=new Image(borderFile.toURI().toString());
        borderImageView.setImage(borderImage);

        File easy_shop_borderFile=new File("Image/easy_shop_border.png");
        Image easy_shop_borderImage=new Image(easy_shop_borderFile.toURI().toString());
        easy_shop_borderImageView.setImage(easy_shop_borderImage);

        File helmetFile=new File("Image/DoubleVisorHelmet.jpg");
        Image helmetImage=new Image(helmetFile.toURI().toString());
        helmetImageView.setImage(helmetImage);
        helmetImageView.setOnMouseClicked(event->openHouseHold(new ActionEvent()));

        File harry_potterFile=new File("Image/harry_potter_novel.jpg");
        Image harry_potterImage=new Image(harry_potterFile.toURI().toString());
        harry_potterImageView.setImage(harry_potterImage);

        File oppoFile=new File("Image/OppoA16.jpg");
        Image oppoImage=new Image(oppoFile.toURI().toString());
        oppoImageView.setImage(oppoImage);
        oppoImageView.setOnMouseClicked(event->openElectronics(new ActionEvent()));

        File bottleFile=new File("Image/StealBottle.jpg");
        Image bottleImage=new Image(bottleFile.toURI().toString());
        bottleImageView.setImage(bottleImage);
        bottleImageView.setOnMouseClicked(event->openHouseHold(new ActionEvent()));

    }

    public void cartButtonOnAction(ActionEvent event){
        try{
            Stage stage1 = (Stage) cartButton.getScene().getWindow();
            stage1.close();
            FXMLLoader fxmlLoader = new FXMLLoader(EazyShop.class.getResource("Cart.fxml"));
            Stage homeStage = new Stage();
            homeStage.initStyle(StageStyle.UNDECORATED);
            homeStage.setScene(new Scene(fxmlLoader.load(), 771, 628));
            homeStage.show();
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void HomeButtonOnAction(ActionEvent event){


    }

    public void categoryButtonOnAction(ActionEvent event){
        MenuItem menuItem1 = new MenuItem("Electronics");
        MenuItem menuItem2 = new MenuItem("Books");
        MenuItem menuItem3 = new MenuItem("Household");
        MenuButton menuButton = new MenuButton("Categories", null, menuItem1, menuItem2, menuItem3);

    }

    public void homeButtonOnAction(ActionEvent actionEvent) {
    }

    public void goToLoginForm()
    {
        try{
            Stage stage1 = (Stage) logOutLink.getScene().getWindow();
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

    public void manufacturerButtonOnAction(){
        try{
            Stage stage1 = (Stage) manufacturerButton.getScene().getWindow();
            stage1.close();
            FXMLLoader fxmlLoader = new FXMLLoader(EazyShop.class.getResource("clothing.fxml"));
            Stage homeStage = new Stage();
            homeStage.initStyle(StageStyle.UNDECORATED);
            homeStage.setScene(new Scene(fxmlLoader.load(), 742, 550));
            homeStage.show();
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void openClothing(ActionEvent actionEvent) {
        try{
            Stage stage1 = (Stage) manufacturerButton.getScene().getWindow();
            stage1.close();
            FXMLLoader fxmlLoader = new FXMLLoader(EazyShop.class.getResource("clothing.fxml"));
            Stage homeStage = new Stage();
            homeStage.initStyle(StageStyle.UNDECORATED);
            homeStage.setScene(new Scene(fxmlLoader.load(), 742, 550));
            homeStage.show();
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void openElectronics(ActionEvent actionEvent) {
        try{
            Stage stage1 = (Stage) manufacturerButton.getScene().getWindow();
            stage1.close();
            FXMLLoader fxmlLoader = new FXMLLoader(EazyShop.class.getResource("electronics.fxml"));
            Stage homeStage = new Stage();
            homeStage.initStyle(StageStyle.UNDECORATED);
            homeStage.setScene(new Scene(fxmlLoader.load(), 742, 550));
            homeStage.show();
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void openHouseHold(ActionEvent actionEvent) {
        try{
            Stage stage1 = (Stage) manufacturerButton.getScene().getWindow();
            stage1.close();
            FXMLLoader fxmlLoader = new FXMLLoader(EazyShop.class.getResource("household.fxml"));
            Stage homeStage = new Stage();
            homeStage.initStyle(StageStyle.UNDECORATED);
            homeStage.setScene(new Scene(fxmlLoader.load(), 742, 550));
            homeStage.show();
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void openbooks(ActionEvent actionEvent) {
        try{
            Stage stage1 = (Stage) manufacturerButton.getScene().getWindow();
            stage1.close();
            FXMLLoader fxmlLoader = new FXMLLoader(EazyShop.class.getResource("Books.fxml"));
            Stage homeStage = new Stage();
            homeStage.initStyle(StageStyle.UNDECORATED);
            homeStage.setScene(new Scene(fxmlLoader.load(), 771, 649));
            homeStage.show();
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }

    /*public void openClothing(ActionEvent actionEvent) {
        try{
            Stage stage1 = (Stage) manufacturerButton.getScene().getWindow();
            stage1.close();
            FXMLLoader fxmlLoader = new FXMLLoader(EazyShop.class.getResource("clothing.fxml"));
            Stage homeStage = new Stage();
            homeStage.initStyle(StageStyle.UNDECORATED);
            homeStage.setScene(new Scene(fxmlLoader.load(), 766, 623));
            homeStage.show();
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }*/
}