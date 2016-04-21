/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import UI.NewUserUI;
import UI.ErrorUI;
import Accounts.UserRepository;

/**
 * -get UI Layer to ask for name, username, password, license plate
 * - send to here
 * - validate things
 * - check and see if account with username already exists 
 * - if it does, display error message.
 * - if it does not, save new user 
 * - register user as logged in 
 * - display that they've been created and should be happy now 
 */
public class NewUser {
    public NewUser(UserRepository UR)
    {
        UR.printRepo();
       // NewUserUI = new NewUserUI();
        NewUserUI user = new NewUserUI();
        String[] userData = user.displayNewUserData();
        String id1 = userData[0];
        int id2;
        id2 = Integer.parseInt(id1);
        String LP = userData[1];
        String Name = userData[2];
        String Username = userData[3];
        String Password = userData[4];
        int x;
        x = UR.logUserIn(Username, Password);
        if(x== 0 || x == 1)
        {
           
            ErrorUI err = new ErrorUI();
            err.displayMessage("User already exists");
        }
        else
        {
            // returned -1
            // call error message UI
            
            UR.newUser(id2, LP, Name, Username, Password);
            
        }
        
    
    }
    
}
