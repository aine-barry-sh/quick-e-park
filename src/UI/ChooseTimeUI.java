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
public class ChooseTimeUI {
    public int display(String [] times) {
        System.out.println("Please enter a number to choose one of the following time periods");
        for (int i =0; i< times.length; i++) {
            System.out.println((i+1) + ") " + times[i]);
        }
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
    
}
