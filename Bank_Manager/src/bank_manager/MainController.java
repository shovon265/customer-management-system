/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bank_manager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author user
 */
public class MainController implements Initializable {

    @FXML
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Database db= new Database();
        db.getConnnection();
        ObservableList<User> list = db.getUsers();
        id.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        email.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        first_name.setCellValueFactory(new PropertyValueFactory<User, String>("first_name"));
        last_name.setCellValueFactory(new PropertyValueFactory<User, String>("last_name"));
        full_name.setCellValueFactory(new PropertyValueFactory<User, String>("full_name"));
        city.setCellValueFactory(new PropertyValueFactory<User, String>("city"));
        table.setItems(list);
        // TODO
    }    
    
}
