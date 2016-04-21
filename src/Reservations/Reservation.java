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
public interface Reservation {
    
    boolean check(int user_id,  int car_park_id, String time);
    boolean check(int reservation_id);
    void complete();
    String toString();
    int getReservationId();
    int getUserId();
}
