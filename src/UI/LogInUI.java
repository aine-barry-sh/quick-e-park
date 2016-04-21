/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.Scanner;

/**
 *
 * @author aineb100
 */
public class LogInUI {
  
    public String[] displayLogIn() {
        String[] details = new String[2];
        
        Scanner in = new Scanner(System.in);
        System.out.print("Username: ");
        details[0] = in.next();
        System.out.print("Password: ");
        details[1] = in.next();
        
        return details;
        
    }
    
    
    
    
}
