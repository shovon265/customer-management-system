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
if (email.getText().trim().equals("admin@gmail.com") && pas.getText().trim().equals("admin123")) {
    try {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        stage.setScene(new Scene(root));
        stage.setTitle("Dashboard");
        stage.show(); // Ensure the stage is updated and displayed
    } catch (IOException e) {
        e.printStackTrace(); // Log the error for debugging
    }
}
    }

    
}
