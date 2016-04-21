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
public class NewUserUI {
    
    public String[] displayNewUserData()
    {
        String[] data = new String[5];
        
        Scanner input = new Scanner(System.in);
        int running = 0;
        int x;
        while(running == 0){
        System.out.print("If student enter 0, if staff enter 1: ");
        x = Integer.parseInt(input.next());
        if(x == 0 || x == 1)
        {
            String y = Integer.toString(x); 
            data[0] = y;
            running = 1;
        }
        else
        {
            System.out.println("Invalid UserType");
        }
        
        }
        System.out.println("Licence Plate: ");
        data[1] = input.next();
        
        System.out.println("Name: ");
        data[2] = input.next();
        
        System.out.println("Username: ");
        data[3] = input.next();
        
        System.out.println("Password: ");
        data[4] = input.next();
        
        return data;
    }
    
}
