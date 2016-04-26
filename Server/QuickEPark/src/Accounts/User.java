/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounts;

/**
 *
 * @author aineb100
 */
public interface User {
    @Override
    String toString();
    boolean validateLogin(String login, String password);
    void create(int user_id, String license_plate, String name, String login, String password);
    int getType();
    String getLicensePlate();
    int getUserId();
    String getName();
}
