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
public class CarpoolReservation implements Reservation{
    private int user_id;
    private int car_park_id;
    private String time;
    private boolean complete;
    private int reservation_id;
    
  
    
    @Override
    public int getUserId() {
        return user_id;
    }

    @Override
    public boolean check(int user_id, int car_park_id, String time) {
        return (this.user_id == user_id && this.car_park_id == car_park_id && this.time.equals(time));
    }
    
    @Override
    public boolean check(int reservation_id)
    {
        return reservation_id == this.reservation_id;
    }

    @Override
    public void complete() {
        this.complete = true;
    }
   
    
    @Override
    public String toString() {
        return "2," + this.user_id +","+this.car_park_id+","+ this.time + 
                "," + this.reservation_id + "," + this.complete;
    }
    
    @Override
    public void create(int user_id, int car_park_id, String time,int reservation_id, boolean complete) {
        this.user_id = user_id;
        this.car_park_id = car_park_id;
        this.time = time;
        this.complete = complete;
        this.reservation_id = reservation_id;
    }

  

    @Override
    public int getReservationId() {
        return this.reservation_id;
    }

    @Override
    public void create(int user_id, int car_park_id, String time, int reservation_id) {
        this.user_id = user_id;
        this.car_park_id = car_park_id;
        this.time = time;
        this.complete = false;
        this.reservation_id = reservation_id;
    }
}
