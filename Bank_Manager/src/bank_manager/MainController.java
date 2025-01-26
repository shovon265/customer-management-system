/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bank_manager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.sql.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class MainController implements Initializable {

    private TableColumn<User, Integer> id;
    @FXML
    private TableColumn<User, String> email;
    @FXML
    private TableColumn<User, String> first_name;
    @FXML
    private TableColumn<User, String> last_name;
    @FXML
    private TableColumn<User, String> full_name;
    @FXML
    private TableColumn<User, String> city;
    @FXML
    private TableView<User> table;
    @FXML
    private TableColumn<User, Float> balance;
    @FXML
    private TextField old_e;
    @FXML
    private TextField f;
    @FXML
    private TextField l;
    @FXML
    private TextField c;
    @FXML
    private TextField e;
    @FXML
    private TextField p;
    @FXML
    private TableColumn<User, String> password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Database db= new Database();
        db.getConnnection();
        ObservableList<User> list = db.getUsers();
        email.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        first_name.setCellValueFactory(new PropertyValueFactory<User, String>("first_name"));
        last_name.setCellValueFactory(new PropertyValueFactory<User, String>("last_name"));
        full_name.setCellValueFactory(new PropertyValueFactory<User, String>("full_name"));
        city.setCellValueFactory(new PropertyValueFactory<User, String>("city"));
        balance.setCellValueFactory(new PropertyValueFactory<User, Float>("Balance"));
        password.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        table.setItems(list);
        
        // TODO
    }    

    @FXML
    private void handleUpdate(ActionEvent event) {
        Database db=new Database();
        Connection con=db.getConnnection();
        ObservableList<User> List=table.getItems();
        Statement st; 
String query = "UPDATE account SET email = ?, password = ?, first_name = ?, last_name = ?, full_name = ?, city = ? WHERE email = ?";
try {
    PreparedStatement pr = con.prepareStatement(query);
    pr.setString(1, e.getText()); // new email
    pr.setString(2, p.getText()); // password
    pr.setString(3, f.getText()); // first_name
    pr.setString(4, l.getText()); // last_name
    pr.setString(5, f.getText() + " " + l.getText()); // full_name
    pr.setString(6, c.getText()); // city
    pr.setString(7, old_e.getText()); // old email for WHERE condition

    int rowsUpdated = pr.executeUpdate();
    if (rowsUpdated > 0) {
        System.out.println("Record updated successfully!");
    } else {
        System.out.println("No record found with the specified old email.");
    }
} catch (Exception ex) {
    ex.printStackTrace();
}
        table.setItems(db.getUsers());
        table.refresh();
    }

    @FXML
    private void handleDeleteUser(ActionEvent event) {
        Database db = new Database();
        Connection con = db.getConnnection();
        String query = "DELETE FROM account WHERE email = '"+old_e.getText()+"'";
        Statement st;
        try{
            st = con.createStatement();
            st.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
        table.setItems(db.getUsers());
        table.refresh();
    }

    @FXML
    private void handleAdd(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("User Registration");
    }
    
}
