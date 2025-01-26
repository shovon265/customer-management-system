/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package bank_manager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.sql.*;

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button btn1;
    @FXML
    private TextField first;
    @FXML
    private TextField last;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField city;
    @FXML
    private TextField balance;

    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnsaveaction1(ActionEvent event) throws IOException {
        Database db = new Database();
        Connection con = db.getConnnection();
String query = "INSERT INTO account (email, password, first_name, last_name, full_name, city,Balance) VALUES (?, ?, ?, ?, ?, ?,?)";
try {
    PreparedStatement pr = con.prepareStatement(query);
    pr.setString(1, email.getText()); // email
    pr.setString(2, password.getText()); // password
    pr.setString(3, first.getText()); // first_name
    pr.setString(4, last.getText()); // last_name
    pr.setString(5, first.getText() + " " + last.getText()); // full_name
    pr.setString(6, city.getText()); // city
    pr.setString(7,balance.getText());

    pr.executeUpdate();
    System.out.println("Record inserted successfully!");
} catch (Exception ex) {
    ex.printStackTrace();
}

        //To main dashboard
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
        window.setScene(scene);
    }

    @FXML
    private void handleBack(ActionEvent event) throws IOException {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
        window.setScene(scene);
    }


    
}
