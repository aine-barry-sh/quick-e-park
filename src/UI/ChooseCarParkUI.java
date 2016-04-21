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
public class ChooseCarParkUI {
    
    
    public int display(String [] carParks) {
        
        System.out.println("The following is the list of carparks available to you");
        for (int i =0; i<carParks.length; i++) {
            System.out.println((i+1) + ") " + carParks[i]);
        }
        System.out.println("Please enter a number to choose a car park");
        
        Scanner in = new Scanner(System.in);
        return in.nextInt();
        
    }
    
}
