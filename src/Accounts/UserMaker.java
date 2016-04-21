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
public class UserMaker {
    private User my_user;
    
    public UserMaker(int type, int user_id, String license_plate, String name, String login, String password) {
        if (type ==0) {
            my_user = new Student(user_id, license_plate, name, login, password);
        } else if (type ==1) {
            my_user = new Staff(user_id, license_plate, name, login, password);
        }
    }

    public User getUser()
    {
        return my_user;
    }
}
