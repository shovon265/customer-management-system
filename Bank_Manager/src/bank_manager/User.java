/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank_manager;

/**
 *
 * @author user
 */
public class User {
    
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private String full_name;
    private String city;
    private Float Balance;

    public User( String email, String password, String first_name, String last_name, String full_name, String city,Float Balance) {
        
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.full_name = full_name;
        this.city = city;
        this.Balance= Balance;
    }

    public void setBalance(Float balance) {
        this.Balance = balance;
    }

    public Float getBalance() {
        return Balance;
    }

    

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setCity(String city) {
        this.city = city;
    }

   

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getCity() {
        return city;
    }
 
}
