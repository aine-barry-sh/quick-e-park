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
public class CarpoolReservation extends ReservationDecorator {
    
    public CarpoolReservation(Reservation res) {
        super(res);
    }
    
    @Override
    public String toString() {
        return "2,"  + super.res.toString();
    }
   
  

   

    
}
