package com.example.demo4;

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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class BooksController implements Initializable {
    @FXML
    private ImageView harrypotter_ImageView;
    @FXML
    private ImageView rumi_imageview;
    @FXML
    private ImageView shakespeare_imageview;
    @FXML
    private ImageView allamaiqbal_imageview;
    @FXML
    Button back;
    @FXML
    Label s_count,h_count,r_count,a_count,t_label,not_label,order_success;
    @FXML
    CheckBox s_chk,h_chk,a_chk,r_chk;
    @FXML
    private ImageView easy_shop_borderImageView;
    @FXML
    int s =0, h =0, r =0, a =0,total=0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        File easy_shop_borderFile=new File("Image/easy_shop_border.png");
        Image easy_shop_borderImage=new Image(easy_shop_borderFile.toURI().toString());
        easy_shop_borderImageView.setImage(easy_shop_borderImage);

        File HarryImage=new File("Image/harry_potter_novel.jpg");
        Image Harry = new Image(HarryImage.toURI().toString());
        harrypotter_ImageView.setImage(Harry);

        File Rumi=new File("Image/Rumi.jpg");
        Image rumi = new Image(Rumi.toURI().toString());
        rumi_imageview.setImage(rumi);

        File Shakespeare=new File("Image/Shakespeare.jpg");
        Image Shakes = new Image(Shakespeare.toURI().toString());
        shakespeare_imageview.setImage(Shakes);

        File AllamaIqbal=new File("Image/AllamIqbal.jpg");
        Image Allama = new Image(AllamaIqbal.toURI().toString());
        allamaiqbal_imageview.setImage(Allama);
    }

    public void s_increment(ActionEvent actionEvent) {
        if(s_chk.isSelected()&& s <99){
            ++s;
            s_count.setText(Integer.toString(s));
            total+=100;
            t_label.setText(Integer.toString(total)+" Rs.");
        }
    }

    public void h_increment(ActionEvent actionEvent) {
        if(h_chk.isSelected()&& h <99){
            ++h;
            h_count.setText(Integer.toString(h));
            total+=300;
            t_label.setText(Integer.toString(total)+" Rs.");
        }
    }

    public void r_increment(ActionEvent actionEvent) {
        if(r_chk.isSelected()&& r <99){
            ++r;
            r_count.setText(Integer.toString(r));
            total+=50;
            t_label.setText(Integer.toString(total)+" Rs.");
        }
    }

    public void a_increment(ActionEvent actionEvent) {
        if(a_chk.isSelected()&& a <99){
            ++a;
            a_count.setText(Integer.toString(a));
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

    public void r_decrement(ActionEvent actionEvent) {
        if(r_chk.isSelected()&& r >0){
            --r;
            r_count.setText(Integer.toString(r));
            total-=300;
            t_label.setText(Integer.toString(total)+" Rs.");
        }
    }

    public void h_decrement(ActionEvent actionEvent) {
        if(h_chk.isSelected()&& h >0){
            --h;
            h_count.setText(Integer.toString(h));
            total-=50;
            t_label.setText(Integer.toString(total)+" Rs.");
        }
    }

    public void a_decrement(ActionEvent actionEvent) {
        if(a_chk.isSelected()&& a >0){
            --a;
            a_count.setText(Integer.toString(a));
            total-=150;
            t_label.setText(Integer.toString(total)+" Rs.");
        }
    }

    public void o_action(ActionEvent actionEvent){
            not_label.setText("");
            String query0;
            String query1;
        String query2;

        LoginController o1=new LoginController();
            DatabaseConnection databaseConnection=new DatabaseConnection();
            Connection connection=databaseConnection.getconnection();
            try {
                Statement statement=connection.createStatement();
                if(s >0&&s_chk.isSelected()){
                    query0="ALTER TABLE order_ AUTO_INCREMENT=1;";
                    query1="insert into order_(status,customer_id) values('Pending',(Select customer_id from customer where username = '"+o1.username+"'));";
                    query2="insert into order_product(order_id,product_id,quantity) values((Select max(order_id) from order_ ),(Select product_id from product where name='Shakespeare'),"+s+");";
                    statement.executeUpdate(query0);
                    statement.executeUpdate(query1);
                    statement.executeUpdate(query2);
                    t_label.setText("");
                    order_success.setText("Ordered Successfully");
                }
                if(h >0&&h_chk.isSelected()){
                    query0="ALTER TABLE order_ AUTO_INCREMENT=1;";
                    query1="insert into order_(status,customer_id) values('Pending',(Select customer_id from customer where username = '"+o1.username+"'));";
                    query2="insert into order_product(order_id,product_id,quantity) values((Select max(order_id) from order_ ),(Select product_id from product where name='Harry Potter'),"+h+");";
                    statement.executeUpdate(query0);
                    statement.executeUpdate(query1);
                    statement.executeUpdate(query2);
                    t_label.setText("");
                    order_success.setText("Ordered Successfully");
                }
                if(a >0&&a_chk.isSelected()){
                    query0="ALTER TABLE order_ AUTO_INCREMENT=1;";
                    query1="insert into order_(status,customer_id) values('Pending',(Select customer_id from customer where username = '"+o1.username+"'));";
                    query2="insert into order_product(order_id,product_id,quantity) values((Select max(order_id) from order_ ),(Select product_id from product where name='Allama Iqbal'),"+a+");";
                    statement.executeUpdate(query0);
                    statement.executeUpdate(query1);
                    statement.executeUpdate(query2);
                    t_label.setText("");
                    order_success.setText("Ordered Successfully");
                }
                if(r >0&&r_chk.isSelected()){
                    query0="ALTER TABLE order_ AUTO_INCREMENT=1;";
                    query1="insert into order_(status,customer_id) values('Pending',(Select customer_id from customer where username = '"+o1.username+"'));";
                    query2="insert into order_product(order_id,product_id,quantity) values((Select max(order_id) from order_ ),(Select product_id from product where name='Rumi'),"+r+");";
                    statement.executeUpdate(query0);
                    statement.executeUpdate(query1);
                    statement.executeUpdate(query2);
                    t_label.setText("");
                    order_success.setText("Ordered Successfully");
                }

            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }

    public void b_action(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)back.getScene().getWindow();
        stage.close();
        Parent root= FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage s_stage = new Stage();
        s_stage.initStyle(StageStyle.UNDECORATED);
        s_stage.setScene(new Scene(root,800,620));
        s_stage.show();
    }


}
