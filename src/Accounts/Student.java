/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounts;

/**
 *
 * @author aineb100
 */
public class Student implements User {
    private int user_id;
    private String license_plate;
    private String name;
    private String login;
    private String password;

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public String getLicensePlate() {
        return license_plate;
    }

    public void setLicensePlate(String license_plate) {
        this.license_plate = license_plate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public Student()
    {
      
    }
    
    @Override
    public void create(int user_id, String license_plate, String name, String login, String password) {
        this.user_id = user_id;
        this.license_plate = license_plate;
        this.name = name;
        this.login = login;
        this.password = password;
    }
    
    @Override
    public String toString()
    {
        return "0," + this.user_id + "," + this.license_plate + ","
                + this.name + "," + this.login + "," + this.password;
    }
    
    @Override
    public boolean validateLogin(String login, String password) {
        return (login.equalsIgnoreCase(this.login) && password.equals(this.password));
    }
    
    @Override
    public int getType() {
        return 0;
    }
}
