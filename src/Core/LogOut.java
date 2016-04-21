/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;
import UI.ErrorUI;
import UI.LogOutUI;

/**
 * - 
 */
public class LogOut {
    LogOutUI logOutUi;
    ErrorUI error;
    public LogOut() {
        logOutUi  = new LogOutUI();
        error = new ErrorUI();
    }
    
    public void triggerLogOut() {
        String choice = logOutUi.logOutChoice();
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes") ) {
            //go to LogIn
        } else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
            
        } else {
        
        }
    }
}
