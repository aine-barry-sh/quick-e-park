/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reservations;

import java.util.ArrayList;
import ReservationData.ReservationDatabase;

public class ReservationRepository {
    
    private ArrayList<Reservation> reservations;
    private ReservationDatabase resDB;
    
    public ReservationRepository () {
        
        resDB = new ReservationDatabase();
        reservations = resDB.getReservations();
        
    }
    
    public void save() {
        resDB.save();
    }
    
    public boolean newReservation(int type, int user_id, int car_park_id, String time) {
        ReservationMaker maker = new ReservationMaker(type);
        maker.create(user_id, car_park_id, time, reservations.size()+1, false);
        if (maker.getReservation() !=null) {
            reservations.add(maker.getReservation());
            return true;
        }
        return false;
    }
    
    private Reservation getReservationWithID( int reservation_id) {
        for (Reservation reservation : reservations) {
            if (reservation.check(reservation_id)) {
                return reservation;
            }
        }
        return null;
    } 
    
    public ArrayList<Reservation> getReservationsForUser(int user_id) {
        ArrayList<Reservation> toReturn = new ArrayList<>();
        
        for (Reservation reservation : reservations) {
            if (user_id == reservation.getUserId()) {
                toReturn.add(reservation);
            }
        }
        return toReturn;
    }
    
    
    public void printRepo()
    {
        for (Reservation reservation : reservations) {
            System.out.println(reservation.toString());
        }
    }
    
    

}
