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
public class ReservationMaker {
    
    private Reservation res;
    
    
    public ReservationMaker(int type) {
        if (type == 0) {
            res = new StudentReservation();
        } else if (type==1) {
            res = new StaffReservation();
        } else if (type==2) {
            res = new CarpoolReservation();
        }
    }
    
    public void create(int user_id, int car_park_id, String time, int reservation_id) {
        res.create(user_id, car_park_id, time, reservation_id);
    }
    public void create(int user_id, int car_park_id, String time,int reservation_id, boolean complete) {
        res.create(user_id, car_park_id, time,reservation_id, complete);
    }
    
    
    public Reservation getReservation()
    {
        return this.res;
    }
}
