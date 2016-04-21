/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Reservations.ReservationRepository;
import Accounts.UserRepository;
import UI.ChooseCarParkUI;
import UI.ChooseCarpoolUI;
import UI.ChooseTimeUI;
import UI.ErrorUI;
/**
 * - check that user is logged in
 * - if not display error message 
 * - check type of logged user 
 * - display list of car parks accordingly 
 * - ask them to pick a number based on which car park 
 * - then ask for a time for the reservation 
 * - validate and save 
 * 
 * displaying receipt will be a different class
 */
public class NewReservation {
    
    private final int loggedInUser; 
    private int carPark;
    private int timeChoice;
    private ErrorUI message;
    private final String [] times = {"00:00-05:59","06:00-11:59","12:00-17:59", "18:00-23:59"};
    
    public NewReservation(int loggedInUser, ReservationRepository resRepo, UserRepository userRepo) {
        this.loggedInUser = loggedInUser;
        message = new ErrorUI();
        
        //triggering operation
        if (loggedInUser == -1) {
            message.displayMessage("There is no user logged in right now");
            return;
        }
        int type = userRepo.checkType(loggedInUser);
        //use type to get correct list of carparks. For now,
        //it is hardcoded within the selectCarPark method
        selectCarPark();
        
        //get account type so we can get the correct list of car parks
        
        if (this.carPark == -1) {
            message.displayMessage("Invalid car park selection");
            return;
        }
        selectTime();
        if (this.timeChoice == -1) {
            message.displayMessage("Invalid time selection");
            return;
        }
        
        if (type ==1) {
            type = checkCarpool();
        }
        resRepo.newReservation(
                type, 
                this.loggedInUser, 
                this.carPark, 
                this.times[timeChoice-1]);
        resRepo.save();
        
    }
    
    
    public void selectCarPark() {
        //use this type to get a list of relevant car parks. 
        //for now assume following array is correct.
        String [] carParks = {"carPark1", "carpark2", "carpark3"};
        int [] carParksIDs = {1,5,8};
        ChooseCarParkUI carParkUI = new ChooseCarParkUI();
        int carParkChoice = carParkUI.display(carParks);
        if (carParkChoice > carParks.length || carParkChoice <= 0) {
            this.carPark = -1;
        } else {
            this.carPark = carParksIDs[carParkChoice-1];
        }
    }
    
    public void selectTime() {
        String [] times = {"00:00-05:59","06:00-11:59","12:00-17:59", "18:00-23:59"};
        ChooseTimeUI chooseTime = new ChooseTimeUI();
        this.timeChoice = chooseTime.display(times);
        if (this.timeChoice > times.length || this.timeChoice <= 0 ) {
            this.timeChoice = -1;
        } 
        
    }
    
    public int checkCarpool() {
        ChooseCarpoolUI chooseCarpool = new ChooseCarpoolUI();
        String response = chooseCarpool.display();
        
        if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
            return 2;
        } else {
            message.displayMessage("no carpool selected.");
            return 1;
        }
    }
    
}
