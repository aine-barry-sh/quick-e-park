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
public class StaffReservation extends ReservationDecorator {
    
    public StaffReservation(Reservation res) {
        super(res);
    }
    
    @Override
    public String toString() {
        
        return "1," + super.res.toString();
    }
}
