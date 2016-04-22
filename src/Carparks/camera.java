/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carparks;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author jconn
 */
public class camera {
    private String plateFromImage;
    
    public String ReadPlate(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the plate number from the image");
        plateFromImage = in.nextLine();
        return plateFromImage;
    }
    
    public int getNumber(){
        return 3;
    }
}
