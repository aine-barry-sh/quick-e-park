package UI;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author aineb100
 */
public class LogOutUI {
    public String logOutChoice() {
        System.out.println("are you sure that you would like to log out? Y/N");
        Scanner in = new Scanner(System.in);
        String choice = in.next();
        return choice;
    }
    
    public void leavingMessage() {
        System.out.println("Sad to see you go!");
    
    }
}
