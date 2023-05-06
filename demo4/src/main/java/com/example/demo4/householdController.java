package com.example.demo4;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class householdController implements Initializable {
    @FXML
    private ImageView headphoneImageView;
    @FXML
    private ImageView arduinoImageView;
    @FXML
    private ImageView chargerImageView;
    @FXML
    private ImageView mobileImageView,easy_shop_borderImageView;
    @FXML
    Button back;
    @FXML
    Label s_count,t_count,j_count,sn_count,t_label,not_label,order_success;
    @FXML
    CheckBox s_chk,t_chk,j_chk,sn_chk;
    @FXML
    int s =0, t =0, j =0, sn =0,total=0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File easy_shop_borderFile=new File("Image/easy_shop_border.png");
        Image easy_shop_borderImage=new Image(easy_shop_borderFile.toURI().toString());
        easy_shop_borderImageView.setImage(easy_shop_borderImage);

        File shirtImage=new File("Image/DoubleVisorHelmet.jpg");
        Image shirt = new Image(shirtImage.toURI().toString());
        headphoneImageView.setImage(shirt);

        File trouserImage=new File("Image/StealBottle.jpg");
        Image trouser = new Image(trouserImage.toURI().toString());
        chargerImageView.setImage(trouser);

        File jacketImage=new File("Image/Dish_Drainer.jpg");
        Image jacket = new Image(jacketImage.toURI().toString());
        arduinoImageView.setImage(jacket);

        File SneakerImage=new File("Image/Water_Dispenser.jpg");
        Image Sneaker = new Image(SneakerImage.toURI().toString());
        mobileImageView.setImage(Sneaker);
    }

    public void s_increment(ActionEvent actionEvent) {
        if(s_chk.isSelected()&& s <99){
            ++s;
            s_count.setText(Integer.toString(s));
            total+=100;
            t_label.setText(Integer.toString(total)+" Rs.");
        }
    }

    public void t_increment(ActionEvent actionEvent) {
        if(t_chk.isSelected()&& j <99){
            ++t;
            t_count.setText(Integer.toString(t));
            total+=300;
            t_label.setText(Integer.toString(total)+" Rs.");
        }
    }

    public void j_increment(ActionEvent actionEvent) {
        if(j_chk.isSelected()&& j <99){
            ++j;
            j_count.setText(Integer.toString(j));
            total+=50;
            t_label.setText(Integer.toString(total)+" Rs.");
        }
    }

    public void sn_increment(ActionEvent actionEvent) {
        if(sn_chk.isSelected()&& sn <99){
            ++sn;
            sn_count.setText(Integer.toString(sn));
            total+=150;
            t_label.setText(Integer.toString(total)+" Rs.");
        }
    }

    public void s_decrement(ActionEvent actionEvent) {
        if(s_chk.isSelected()&& s >0){
            --s;
            s_count.setText(Integer.toString(s));
            total-=100;
            t_label.setText(Integer.toString(total)+" Rs.");
        }
    }

    public void t_decrement(ActionEvent actionEvent) {
        if(t_chk.isSelected()&& t >0){
            --t;
            t_count.setText(Integer.toString(t));
            total-=300;
            t_label.setText(Integer.toString(total)+" Rs.");
        }
    }

    public void j_decrement(ActionEvent actionEvent) {
        if(j_chk.isSelected()&& j >0){
            --j;
            j_count.setText(Integer.toString(j));
            total-=50;
            t_label.setText(Integer.toString(total)+" Rs.");
        }
    }

    public void sn_decrement(ActionEvent actionEvent) {
        if(sn_chk.isSelected()&& sn >0){
            --sn;
            sn_count.setText(Integer.toString(sn));
            total-=150;
            t_label.setText(Integer.toString(total)+" Rs.");
        }
    }

    public void o_action(ActionEvent actionEvent){
            not_label.setText("");
        LoginController o1=new LoginController();
            String query0;
            String query1;
            String query2;
            DatabaseConnection databaseConnection=new DatabaseConnection();
            Connection connection=databaseConnection.getconnection();
        try {
            Statement statement=connection.createStatement();
            if(s >0&&s_chk.isSelected()){
                query0="ALTER TABLE order_ AUTO_INCREMENT=1;";
                query1="insert into order_(status,customer_id) values('Pending',(Select customer_id from customer where username = '"+o1.username+"'));";
                query2="insert into order_product(order_id,product_id,quantity) values((Select max(order_id) from order_ ),(Select product_id from product where name='Headphone'),"+s+");";
                statement.executeUpdate(query0);
                statement.executeUpdate(query1);
                statement.executeUpdate(query2);
                t_label.setText("");
                order_success();
            }
            if(j >0&&j_chk.isSelected()){
                query0="ALTER TABLE order_ AUTO_INCREMENT=1;";
                query1="insert into order_(status,customer_id) values('Pending',(Select customer_id from customer where username = '"+o1.username+"'));";
                query2="insert into order_product(order_id,product_id,quantity) values((Select max(order_id) from order_ ),(Select product_id from product where name='Arduino'),"+j+");";
                statement.executeUpdate(query0);
                statement.executeUpdate(query1);
                statement.executeUpdate(query2);
                t_label.setText("");
                order_success();
            }
            if(t >0&&t_chk.isSelected()){
                query0="ALTER TABLE order_ AUTO_INCREMENT=1;";
                query1="insert into order_(status,customer_id) values('Pending',(Select customer_id from customer where username = '"+o1.username+"'));";
                query2="insert into order_product(order_id,product_id,quantity) values((Select max(order_id) from order_ ),(Select product_id from product where name='Charger'),"+t+");";
                statement.executeUpdate(query0);
                statement.executeUpdate(query1);
                statement.executeUpdate(query2);
                t_label.setText("");
                order_success();
            }
            if(sn >0&&sn_chk.isSelected()){
                query0="ALTER TABLE order_ AUTO_INCREMENT=1;";
                query1="insert into order_(status,customer_id) values('Pending',(Select customer_id from customer where username = '"+o1.username+"'));";
                query2="insert into order_product(order_id,product_id,quantity) values((Select max(order_id) from order_ ),(Select product_id from product where name='Oppo A16'),"+sn+");";
                statement.executeUpdate(query0);
                statement.executeUpdate(query1);
                statement.executeUpdate(query2);
                t_label.setText("");
                order_success();
            }

            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }
    void order_success(){
        order_success.setText("Ordered Successfully");
        PauseTransition visiblePause = new PauseTransition(
                Duration.seconds(3)
        );
        visiblePause.setOnFinished(
                event -> order_success.setText("")
        );
        visiblePause.play();
    }
    public void b_action(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)back.getScene().getWindow();
        stage.close();
        Parent root= FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage s_stage = new Stage();
        s_stage.initStyle(StageStyle.UNDECORATED);
        s_stage.setScene(new Scene(root,766,623));
        s_stage.show();
    }

    public void s_chk_action(ActionEvent actionEvent) {
    }
}
