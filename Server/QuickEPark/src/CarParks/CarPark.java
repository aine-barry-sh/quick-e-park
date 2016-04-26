/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carparks;

/**
 *
 * @author jconn
 */
public class CarPark implements CarFace {
    private int ID;
    private String name;
    private int studentCapacity;
    private int staffCapacity;
    private int staffOccupants;
    private int studentOccupants;
    private camera cam;
    
    public CarPark(int ID, String name, int studentCapacity, int staffCapacity){
        this.ID = ID;
        this.name = name;
        this.studentCapacity = studentCapacity;
        this.staffCapacity = staffCapacity;
        this.studentOccupants = 0;
        this.staffOccupants = 0;
        this.cam = new camera();
    }
    
    public CarPark(int ID, String name, int studentCapacity, int staffCapacity, int studentOccupants, int staffOccupants){
        this.ID = ID;
        this.name = name;
        this.studentCapacity = studentCapacity;
        this.staffCapacity = staffCapacity;
        this.studentOccupants = studentOccupants;
        this.staffOccupants = staffOccupants;
        this.cam = new camera();
    }

    
    
    @Override
    public void newSession(int type) {
       if((type == 1 || type == -1) && studentOccupants < studentCapacity){
           studentOccupants++;
           System.out.println("Student added to " + this.name + this.staffCapacity + " "+ this.studentOccupants);
       }
       else if((type == 1 || type == -1)){
           System.out.println("Students Full");
       }
       else if(type ==0 && staffOccupants < staffCapacity){
           staffOccupants++;
           System.out.println("Staff member added to " + this.name);
       }
       else{
           System.out.println("Staff full");
       }
    }

    @Override
    public void finishSession(int type) {
       if(type == 1){
           studentOccupants --;
            System.out.println("Student leaving " + this.name);
       }
       else{
           staffOccupants --;
           System.out.println("Staff leaving " + this.name);
       }
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String toString(){
     
        return this.getID() + "," + this.name + "," + this.studentCapacity + "," + this.staffCapacity + "," + this.studentOccupants + "," + this.staffOccupants;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }
    
    public String getName(){
        return name;
    }
    
    public String getPlate(){
        return cam.ReadPlate();
    }
    
    public int getNumberInCar(){
        return cam.getNumber();
    }
    
}
