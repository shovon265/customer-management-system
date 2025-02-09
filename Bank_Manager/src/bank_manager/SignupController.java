/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bank_manager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 */
public class SignupController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private TextField name;
    @FXML
    private TextField password;
    @FXML
    private TextField cpassword;
    @FXML
    private TextField phone;
    @FXML
    private Label emsg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleSignUp(ActionEvent event) {
        if(!password.getText().equals(cpassword.getText())){
            emsg.setText("Password did not matched");
        }
        else{
            Database db = new Database();
            Connection conn = db.getConnnection();
            String query = "INSERT INTO admin (name,email,password,phone) VALUES (?,?,?,?)";
            String finding = "SELECT EXISTS(SELECT email FROM admin WHERE email = ?)";
            
            try{
                
                PreparedStatement st = conn.prepareStatement(query);
                PreparedStatement pt = conn.prepareStatement(finding);
                             
                pt.setString(1,email.getText());
                ResultSet rs = pt.executeQuery();
                 if (rs.next() && rs.getInt(1) == 1) {
                    
                     emsg.setText("Account Already Exist");
                     return ;
        }

                st.setString(1,name.getText());
                st.setString(2,email.getText());
                st.setString(3, password.getText());
                st.setString(4,phone.getText());
                st.executeUpdate();
                
                //switch Scene
                Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
                Stage stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
                stage.setScene(new Scene(root));
                stage.show();
                
            }catch(Exception e){
                
                e.printStackTrace();
            }
        }
    }
    
}
