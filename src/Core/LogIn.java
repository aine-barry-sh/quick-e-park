/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import UI.*;
import Accounts.*;

/**
 *Necessary steps 
 * -check if there is already a user logged in (userLoggedIn == -1)
 * -get UI layer to display text asking for password and username
 * -read in information on UI layer and pass to here
 * -send to user package to validate 
 * -if correct, set user as logged in on main file. If incorrect display error message
 *          and prompt user to try again
 * 
 * logged in user is handled by an int in the Handler class
 */
public class LogIn {
    private int userLoggedIn;
    private ErrorUI errorUI;
    
    
    public LogIn(int userLoggedIn, UserRepository UR) {
        this.userLoggedIn = userLoggedIn;
        errorUI = new ErrorUI();
        
        triggerLogIn(UR);
        
        
    }
    
    public int getLoggedInUser() {
        return this.userLoggedIn;
    }
    
    
    private void triggerLogIn(UserRepository userRepo) {
        LogInUI logUi = new LogInUI();
        String [] details = logUi.displayLogIn();
        int testLogIn = userRepo.logUserIn(details[0], details[1]);
        while (testLogIn==-1) {
            errorUI.displayMessage("Invalid login. Try again");
            triggerLogIn(userRepo);
        }  
        if (testLogIn!=-1) {
            this.userLoggedIn = testLogIn;
            errorUI.displayMessage("Welcome " + userRepo.getUserFullName(testLogIn));
        } else {
            errorUI.displayMessage("You should not have gotten to here");
        }
        
    }
}
