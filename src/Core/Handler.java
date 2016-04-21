/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;
import Accounts.UserRepository;
import Reservations.ReservationRepository;
import java.util.Scanner;
/**
 *
 * @author aineb100
 */
public class Handler {
    
    private UserRepository userDB;
    private ReservationRepository resDB;
    private int loggedInUser;
    
    public Handler() {
        userDB = new UserRepository();
        resDB = new ReservationRepository();
        
        
        triggerDemo();

    }
    private void save() {
        userDB.save();
        resDB.save();
    }
    
    
    private void newReservation() {
        NewReservation reservation = new NewReservation(this.loggedInUser, this.resDB, this.userDB);
//        reservation.trigger();
    }
    
    
    private boolean triggerDemo() {
        System.out.println("Enter 1 for new user use case and 2 for new reservation use case");
        Scanner in = new Scanner(System.in);
        String choice = in.next();
        
        if (choice.equals("1")) {
            NewUser newUser = new NewUser(userDB);
        } else if (choice.equals("2")) {
            
            //call log in handler
            LogIn logIn = new LogIn(loggedInUser, userDB);
            loggedInUser = logIn.getLoggedInUser();
            if (loggedInUser !=-1) {
                //print before and after to demonstrate that 
                //the new reservation was saved.
                resDB.printRepo();
                newReservation();
                resDB.printRepo();
                
            } else {
                System.out.println("error");
            } 
        } else {
            System.out.println("you can't do that");
        }
        
        System.out.println("Would you like to do another use case? y/n");
        String anotherGo = in.next();
        
        if (anotherGo.equalsIgnoreCase("y")) {
            triggerDemo();
        } else {
            save();
            return true;
        }
        
        return true;
        
    }
    
   
}
