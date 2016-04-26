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
public class ReservationDecorator implements Reservation{
    
    protected Reservation res;
    
    public ReservationDecorator(Reservation newRes) {
        this.res = newRes;
    }

    @Override
    public boolean check(int user_id, int car_park_id, String time) {
        return this.res.check(user_id, car_park_id, time);
    }

    @Override
    public boolean check(int reservation_id) {
        return this.res.check(reservation_id);
    }

    @Override
    public void complete() {
       this.res.complete();
    }

    @Override
    public int getReservationId() {
        return this.res.getReservationId();
    }

    @Override
    public int getUserId() {
        return this.res.getUserId();
    }
    
    @Override 
    public String toString() {
        return this.res.toString();
    }
    
}
