/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Carparks;


import java.util.ArrayList;
import Carparks.Data.CarParksData;

/**
 *
 * @author jconn
 */
public class CarParkRepo {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    private ArrayList<CarFace> CarParks;
    private CarParksData carparksDB;
    
    
    public CarParkRepo () {
       carparksDB = new CarParksData();
       CarParks = carparksDB.getCarParks();
    }
    
    public void newCarPark(
           int ID, String name, int studentCapacity, int staffCapacity, int studentOccupants, int staffOccupants) {
        
        CarFace c = new CarPark(ID,name,studentCapacity, staffCapacity, studentOccupants, staffOccupants);
        CarParks.add(c);
        this.save();
    }
    

    
    
    public void printRepo()
    {
        for (CarFace aCarPark: CarParks) {
            System.out.println(aCarPark.toString());
        }
    }
    
    
    public void save() {
        carparksDB.save();
    }
    
    
    private CarFace getCarPark(int id) {
        for (CarFace  aCarPark : CarParks) {
            if (aCarPark.getID() ==  id) {
                return aCarPark;
            }
        }
        
        return null;
    }
    
    public String getCarParkName(int id) {
        CarFace aCarPark = this.getCarPark(id);
        
        if (aCarPark != null) {
            return aCarPark.getName();
        } else {
            return "n/a";
        } 
    }
    
    public void addUserToCarPark(int carParkID, int userID){
        CarFace c = this.getCarPark(carParkID);
        c.newSession(userID);
    }
    
    public int getNextID(){
        return CarParks.size()+1;
    }
    
   public String readPlateFromBarrier(int currentCarParkID){
       int indexID = -1;
               System.out.println("current " + currentCarParkID);
       for(CarFace aCarPark : CarParks){
           if(aCarPark.getID() == currentCarParkID){
                          System.out.println(aCarPark.getID());
               indexID = CarParks.indexOf(aCarPark);
           }
       }
       System.out.println(CarParks.size() + "  ... " + indexID);
       return CarParks.get(indexID).getPlate();
   }
   
   public int getNumberInCar(int currentCarParkID){
        CarFace currentCarPark = null;
        System.out.println("current " + currentCarParkID);
       for (CarFace  aCarPark : CarParks) {
           if(aCarPark.getID() == currentCarParkID){
                              currentCarPark = aCarPark;
                              break;
           }
       }
       return currentCarPark.getNumberInCar();
   }
}

