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
public interface UserFace {
    public void setName(String n);
    public void setStudent(boolean s);
    public String getName();
    public boolean isStudent();
    public int getValue();
    public void addMember(UserFace u);
}
