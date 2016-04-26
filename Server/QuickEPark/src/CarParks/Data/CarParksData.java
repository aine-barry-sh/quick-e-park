/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carparks.Data;

import Carparks.CarFace;
import Carparks.CarPark;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jconn
 */
public class CarParksData {
     private ArrayList<CarFace> carparks;
    
    public CarParksData () {
        carparks = new ArrayList<>();
        try {
            File file = new File("src\\CarParks\\Data\\carparks.csv");
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                    createCarPark(in.nextLine());
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("error: " +e);
        }
    }
    
    public void createCarPark(String line)
    {
        String [] parts = line.split(",");
        CarFace c = new CarPark(Integer.parseInt(parts[0]),parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
        carparks.add(c);
    }
    
    public ArrayList<CarFace> getCarParks()
    {
        return this.carparks;
    }
    
    public void setCarParks(ArrayList<CarFace> users) {
        this.carparks.clear();
        this.carparks = users;
    }
    
    
    //to be called on destruction
    public void save() {
        if (carparks.size() >0 ) {
            try {
                PrintWriter writer = new PrintWriter("src\\CarParks\\Data\\carparks.csv", "UTF-8");
                for (CarFace aCarPark : carparks) {
                    writer.println(aCarPark.toString());
                }
                writer.close();
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                System.out.println("Error: " + e);
            }
        }
    }
}
