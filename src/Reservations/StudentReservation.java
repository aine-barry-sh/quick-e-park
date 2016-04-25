/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reservations;

/**
 *
 * @author aineb100
 */
public class StudentReservation extends ReservationDecorator {
    
   
    public StudentReservation (Reservation res) {
        super(res);
    }
    
    @Override
    public String toString() {
        return "0,"  + super.res.toString();
    }
    
    
}
