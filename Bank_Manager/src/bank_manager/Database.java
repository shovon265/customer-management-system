/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank_manager;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class Database {
        public Connection getConnnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
            System.out.println("db connected");
            return conn;
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            System.out.println("unsuccessful connection");
            return null;
        }
    }
    
        public ObservableList<User> getUsers() {
        ObservableList<User> userList = FXCollections.observableArrayList();
        Connection conn = getConnnection();
        String query = "SELECT * FROM account";
        
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            User user = null;
            while (rs.next()) {
//                 public User(int id, String email, String password, String first_name, String last_name, String full_name, String city)
                user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("first_name"), rs.getString("last_name"),rs.getString("full_name"),rs.getString("city"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }
}
