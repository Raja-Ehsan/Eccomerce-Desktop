package com.example.demo4;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

public class clothingController implements Initializable {
    @FXML
    private ImageView shirtImageView;
    @FXML
    private ImageView jacketImageView;
    @FXML
    private ImageView trouserImageView;
    @FXML
    private ImageView sneakersImageView,easy_shop_borderImageView;
    @FXML
    Button back;
    @FXML
    Label s_count,t_count,j_count,sn_count,t_label,not_label,order_success;
    @FXML
    CheckBox s_chk,t_chk,j_chk,sn_chk;
    @FXML
    private MenuItem s_small,s_medium,s_large,t_small,t_medium,t_large,j_small,j_medium,j_large,sn_small,sn_medium,sn_large;
    int s =0, t =0, j =0, sn =0,total=0;
    @FXML
    MenuButton s_size,j_size,t_size,sn_size;
    String S_size,J_size,T_size,SN_size;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File easy_shop_borderFile=new File("Image/easy_shop_border.png");
        Image easy_shop_borderImage=new Image(easy_shop_borderFile.toURI().toString());
        easy_shop_borderImageView.setImage(easy_shop_borderImage);

        File shirtImage=new File("Image/shirt.jpg");
        Image shirt = new Image(shirtImage.toURI().toString());
        shirtImageView.setImage(shirt);

        File trouserImage=new File("Image/trouser.jpg");
        Image trouser = new Image(trouserImage.toURI().toString());
        trouserImageView.setImage(trouser);

        File jacketImage=new File("Image/Jacket.jpg");
        Image jacket = new Image(jacketImage.toURI().toString());
        jacketImageView.setImage(jacket);

        File SneakerImage=new File("Image/Sneakers.jpg");
        Image Sneaker = new Image(SneakerImage.toURI().toString());
        sneakersImageView.setImage(Sneaker);
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

    public void s_small_action(ActionEvent actionEvent) {
        if(s_chk.isSelected()) {
            S_size = "small";
            if (s_small.isVisible()) {
                s_size.setText("Small");
            }
        }

    }

    public void s_medium_action(ActionEvent actionEvent) {
        if(s_chk.isSelected()) {
            S_size = "Medium";
            if (s_medium.isVisible())
                s_size.setText("Medium");
        }

    }

    public void s_large_action(ActionEvent actionEvent) {
        if(s_chk.isSelected()) {
            S_size = "Large";
            if (s_large.isVisible())
                s_size.setText("Large");
        }

    }


    public void s_chk_action(ActionEvent actionEvent) {
        if(!s_chk.isSelected())
            s_size.setText("Size");
    }

    public void j_small_action(ActionEvent actionEvent) {
        if(j_chk.isSelected()) {
            J_size="small";
            if (j_small.isVisible())
                j_size.setText("Small");
        }

    }

    public void j_medium_action(ActionEvent actionEvent) {
        if(j_chk.isSelected()) {

            J_size="medium";
            if (j_medium.isVisible())
                j_size.setText("Medium");
        }

    }

    public void j_large_action(ActionEvent actionEvent) {
        if(j_chk.isSelected()) {
            J_size="large";
            if (j_large.isVisible())
                j_size.setText("Large");
        }

    }


    public void j_chk_action(ActionEvent actionEvent) {
        if(!j_chk.isSelected())
            j_size.setText("Size");
    }

    public void t_small_action(ActionEvent actionEvent) {
        if(t_chk.isSelected()) {
            T_size="small";
            if (t_small.isVisible())
                t_size.setText("Small");
        }

    }

    public void t_medium_action(ActionEvent actionEvent) {
        if(t_chk.isSelected()) {

            T_size="medium";
            if (t_medium.isVisible())
                t_size.setText("Medium");
        }

    }

    public void t_large_action(ActionEvent actionEvent) {
        if(t_chk.isSelected()) {

            T_size="large";
            if (t_large.isVisible())
                t_size.setText("Large");
        }

    }

    public void t_chk_action(ActionEvent actionEvent) {
        if(!t_chk.isSelected())
            t_size.setText("Size");
    }

    public void sn_small_action(ActionEvent actionEvent) {
        if(sn_chk.isSelected()) {

            SN_size="small";
            if (sn_small.isVisible())
                sn_size.setText("Small");
        }

    }

    public void sn_medium_action(ActionEvent actionEvent) {
        if(sn_chk.isSelected()) {

            SN_size="medium";
            if (sn_medium.isVisible())
                sn_size.setText("Medium");
        }

    }

    public void sn_large_action(ActionEvent actionEvent) {
        if(sn_chk.isSelected()) {
            SN_size="large";
            if (sn_large.isVisible())
                sn_size.setText("Large");
        }

    }

    public void sn_chk_action(ActionEvent actionEvent) {
        if(!sn_chk.isSelected())
            sn_size.setText("Size");
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
                    query2="insert into order_product(order_id,product_id,quantity,size) values((Select max(order_id) from order_ ),(Select product_id from product where name='Shirt'),"+s+",'"+S_size+"');";
                    statement.executeUpdate(query0);
                    statement.executeUpdate(query1);
                    statement.executeUpdate(query2);
                    t_label.setText("");
                    order_success();
                }
                if(j >0&&j_chk.isSelected()){
                    query0="ALTER TABLE order_ AUTO_INCREMENT=1;";
                    query1="insert into order_(status,customer_id) values('Pending',(Select customer_id from customer where username = '"+o1.username+"'));";
                    query2="insert into order_product(order_id,product_id,quantity,size) values((Select max(order_id) from order_ ),(Select product_id from product where name='Jacket'),"+j+",'"+J_size+"');";
                    statement.executeUpdate(query0);
                    statement.executeUpdate(query1);
                    statement.executeUpdate(query2);
                    t_label.setText("");
                    order_success();
                }
                if(t >0&&t_chk.isSelected()){
                    query0="ALTER TABLE order_ AUTO_INCREMENT=1;";
                    query1="insert into order_(status,customer_id) values('Pending',(Select customer_id from customer where username = '"+o1.username+"'));";
                    query2="insert into order_product(order_id,product_id,quantity,size) values((Select max(order_id) from order_ ),(Select product_id from product where name='Trousers'),"+t+",'"+T_size+"');";
                    statement.executeUpdate(query0);
                    statement.executeUpdate(query1);
                    statement.executeUpdate(query2);
                    t_label.setText("");
                    order_success();
                }
                if(sn >0&&sn_chk.isSelected()){
                    query0="ALTER TABLE order_ AUTO_INCREMENT=1;";
                    query1="insert into order_(status,customer_id) values('Pending',(Select customer_id from customer where username = '"+o1.username+"'));";
                    query2="insert into order_product(order_id,product_id,quantity,size) values((Select max(order_id) from order_ ),(Select product_id from product where name='Sneakers'),"+sn+",'"+SN_size+"');";
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

}
