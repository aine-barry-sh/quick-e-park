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
public interface CarFace {
    public void newSession(int type);
    public void finishSession(int type);
    public boolean isFull();
    public int getID();
    public String getName();
    public String getPlate();
    public int getNumberInCar();
}
