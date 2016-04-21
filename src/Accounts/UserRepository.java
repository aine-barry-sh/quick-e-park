/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounts;

import java.util.ArrayList;
import AccountsData.AccountsDatabase;

/**
 *
 * @author aineb100
 */
public class UserRepository {
    private ArrayList<User> users;
    private AccountsDatabase usersDB;
    
    
    public UserRepository () {
       usersDB = new AccountsDatabase();
       users = usersDB.getUsers();
    }
    
    public void newUser(
            int type, String license_plate, 
            String name, String login, String password) {
        
        UserMaker user_maker = new UserMaker(type, users.size()+1, license_plate, name, login, password);
        users.add(user_maker.getUser());
        save();
    
    }
    //returns user_id for user with relevant license plate.
    //if none exists, returns -1
    public int getUserWithLicensePlate(String license_plate) {
        for (User my_user : users) {
            if (license_plate.equalsIgnoreCase(my_user.getLicensePlate())) {
                return my_user.getUserId();
            } 
        }
        return -1;
    }
    
    //if type == student, return 0
    //if type == staff, return 1
    //if no account exists, return -1
    public int checkType(int user_id) {
        for (User my_user : users) {
            if (user_id == my_user.getUserId()) {
                return my_user.getType();
            }
        }
        return -1;
    }
    
    public void printRepo()
    {
        for (User my_user: users) {
            System.out.println(my_user.toString());
        }
    }
    
    
    public int logUserIn(String username, String password) {
        for (User my_user : users) {
            if (my_user.validateLogin(username, password)) {
                return my_user.getUserId();
            }
        }
        return -1;
    }
    
    
    public void save() {
        usersDB.save();
    }
    private User getUserFromID(int id) {
        for (User my_user : users) {
            if (my_user.getUserId() ==  id) {
                return my_user;
            }
        }
        
        return null;
    }
    
    public String getUserFullName(int id) {
        User my_user = this.getUserFromID(id);
        
        if (my_user != null) {
            return my_user.getName();
        } else {
            return "n/a";
        } 
    }
}
