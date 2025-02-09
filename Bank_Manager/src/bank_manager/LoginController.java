/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
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
 * FXML Controller class
 *
 * @author user
 */
public class LoginController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button btn1;
    @FXML
    private Label e_msg;
    @FXML
    private TextField email;
    @FXML
    private TextField pas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        Database db = new Database();
        Connection conn = db.getConnnection();
        String query = "SELECT * FROM admin WHERE email = ?";
    try {
        
        PreparedStatement pt = conn.prepareStatement(query);
        pt.setString(1, email.getText());
        ResultSet rs;
        rs = pt.executeQuery();
        if(rs.next()){
            
            if(pas.getText().equals(rs.getString("password"))){
                        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        stage.setScene(new Scene(root));
        stage.setTitle("Dashboard");
        stage.show(); // Ensure the stage is updated and displayed
            }else{
                e_msg.setText("Incorrect Password");
            }
                    

        } else{
            e_msg.setText("Account does not exist!");
        }
        

    } catch (Exception e) {
        e.printStackTrace(); // Log the error for debugging
    }
}

    @FXML
    private void handleSignup(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Stage stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        stage.setScene(new Scene(root));
        stage.show();
    }

    
}
