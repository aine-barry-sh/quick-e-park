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
// This should be an abstract class once classes for student and staff have been created
public class user  implements UserFace{
    private String name;
    private boolean student;
    
    public user(String name, boolean student){
        this.name = name;
        this.student = student;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the student
     */
    public boolean isStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(boolean student) {
        this.student = student;
    }

    @Override
    public int getValue() {
       return 1;
    }
    
public void addMember(UserFace u){
    System.out.println("Can not add a component to a leave node");
}
    
    
    
}
