/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclient;

/**
 *
 * Create a new user
 */
public class UseCase3 {
    public void UseCase3()
    {
        Client c = new Client("James", "127.0.0.1", 41122);
        c.openConnection("127.0.0.1");
        
        System.out.println("Use Case 3");
        byte[] data = new byte[1024];
        String msg = "/nu/" + "0" + "/nu/" + "Plate5" + "/nu/" + "John Smith" + "/nu/" + "123456789" + "/nu/" + "password1";
        data = msg.getBytes();
        System.out.println("New User added");
        c.send(data);
        
        
    }
    
}
