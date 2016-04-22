/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Accounts.UserRepository;
import Carparks.CarParkRepo;
import Reservations.ReservationRepository;

/**
 * - take photo of license plate 
 * - return plate to here 
 * - send plate to users to get user_id 
 * - send user_id and time to reservations to see if there's a valid registration
 * - send plate to reservations to check if there's a valid registration.
 * - return user_id if present, else return -1
 * - if type != -1, get type of reservation 
 * -    type == 0 reservation is for a student
 *      type == 1 reservation is for staff
 *      type == 2 reservation is for carpool
 * -if carpool, take picture of car and see if number of people >=3 
 *      dummy method, just return whatever
 *      if correct number is not present, display message and change reservation to staff reservation
 * - if conditions are met, let them in :) 
 *          append the relevant occupant field in carparks (if it was a staff reservation, +1 to number of staff members in the carpark)
 *          credit the user's account for the relevant amount
 *          set complete in the reservation to true
 * 
 * MAYBE DO
 * if the user arrives at the barrier but does not have a reservation 
 */
public class CarArrivesAtCarPark {
    private int currentCarPark;
    private int currentUser;
    private CarParkRepo carparkDB;
    private UserRepository userDB;
    private ReservationRepository resDB;
    
   public CarArrivesAtCarPark(CarParkRepo carparkDB, UserRepository userDB, ReservationRepository resDB, int currentCarPark){
       this.currentCarPark = currentCarPark;
      // this.currentUser = currentUser;
       this.carparkDB = carparkDB;
       this.userDB = userDB;
       this.resDB = resDB;
   }
    
   public void carArrives(){
       int userAtBarrier = -1;
       String plate = carparkDB.readPlateFromBarrier(currentCarPark);
        userAtBarrier = userDB.getUserWithLicensePlate(plate);
       if(resDB.getReservationsForUser(userAtBarrier).size() == 0){
           System.out.println("No reservation found, you will be charged extra for this stay");
           carparkDB.addUserToCarPark(currentCarPark, userDB.checkType(userAtBarrier));
       }
       else if(resDB.getReservationsForUser(userAtBarrier).size() > 0){
           int numberInCar = carparkDB.getNumberInCar(currentCarPark);
           System.out.println(numberInCar + " people detected in car");
           carparkDB.addUserToCarPark(currentCarPark, userDB.checkType(userAtBarrier));
       }
   }
}
