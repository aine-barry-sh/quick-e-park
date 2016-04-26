/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReservationData;

import Reservations.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aineb100
 */
public class ReservationDatabase {
    private ArrayList<Reservation> reservations;
    
    public ReservationDatabase() {
        reservations = new ArrayList<>();
        try {
            File file = new File("src\\ReservationData\\reservations.txt");
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                    createReservation(in.nextLine());
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("error: " +e);
        }
    }
    
    
    private void createReservation(String file_line) {
        String [] parts = file_line.split(",");
        boolean toSend = false;
        if (parts[5].equals("true")) {
            toSend = true;
        }
        ReservationMaker  maker = new ReservationMaker(
                Integer.parseInt(parts[0]),
                Integer.parseInt(parts[1]), 
                Integer.parseInt(parts[2]), 
                parts[3],
                Integer.parseInt(parts[4]), 
                toSend);
        if (maker.getReservation() != null) {
            reservations.add(maker.getReservation());
        }
        else
                        System.out.println("maker failed");
        save();
    }
    
    
    
    public ArrayList<Reservation> getReservations()
    {
        return this.reservations;
    }
    
    public void setReservations(ArrayList<Reservation> reservations)
    {
        this.reservations.clear();
        this.reservations = reservations;
    }
    
    
    public void save() 
    {
        if (reservations.size() >0 ) {
            try {
                PrintWriter writer = new PrintWriter("src\\ReservationData\\reservations.txt", "UTF-8");
                for (Reservation reservation : reservations) {
                    writer.println(reservation.toString());
                }
                writer.close();
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                System.out.println("Error: " + e);
            } 
        }
    }
}
