/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bank_manager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.sql.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
        table.setItems(list);
        
        // TODO
    }    

    @FXML
    private void handleUpdate(ActionEvent event) {
        Database db=new Database();
        Connection con=db.getConnnection();
        ObservableList<User> List=table.getItems();
        for(User u:List){
            if(u.getEmail()==email.getText()){
                u.setEmail(e.getText());
                u.setFirst_name(f.getText());
                u.setLast_name(l.getText());
                u.setFull_name(u.getFirst_name()+ " "+u.getLast_name());
                table.refresh();
            }
        }
    }

    @FXML
    private void handleDeleteUser(ActionEvent event) {
    }
    
}
