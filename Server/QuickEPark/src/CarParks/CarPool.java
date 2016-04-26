/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carparks;

import java.util.ArrayList;

/**
 *
 * @author jconn
 */
public class CarPool extends user {
    private ArrayList<UserFace> members;
    
  
    public CarPool(String name, boolean student) {
        super(name, student);
        members = new ArrayList<UserFace>(5);
        members.ensureCapacity(5);
    }
    
    public void addMember(UserFace u){
        if(!members.contains(u))
            members.add(u);
        else
            System.out.println("This carpool already contains " + u.getName());
    }
    
    public int getValue(){
        int value = 0;
        for(int i = 0; i < members.size();i++){
            value += members.get(i).getValue();
        }
        return value;
    }
   
}
