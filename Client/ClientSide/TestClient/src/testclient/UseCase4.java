/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclient;

import java.util.Scanner;


/**
 *
 * @author ZeCaptain
 */
public class UseCase4 {
    public void UseCase4()
    {
              System.out.println("Use Case 4");
     Client c = new Client("James", "127.0.0.1", 41122);
        c.openConnection("127.0.0.1");

        String username, password, input = "";
        Boolean loggedIn = false;
        Scanner in = new Scanner(System.in);
        byte[] data = new byte[1024];
        int userID = -1;
        System.out.println("This class can be used to the Quick-E-Park Server");
        System.out.println("Firstly, lets try loggin in:");
        do {
            
            username = "12128996";
            
            password = "password";
            data = ("/c/" + username + "/c/" + password).getBytes();
            c.send(data);
            String recieved = c.recieve().trim();
            if (!recieved.equals("/c/-1")) {
                loggedIn = true;
                userID = Integer.parseInt(recieved.split("/c/")[1]);
                System.out.println("Great, you logged in as 12128996!");
            }

        } while (!loggedIn);
        enterCarPark(userID, c);
    }
    
    public static void enterCarPark(int userID, Client c) {
        System.out.println("Enter Car park");
        Scanner in = new Scanner(System.in);
        byte[] data = new byte[1024];
        int carparkIndex = 1;
        System.out.println("Car park one selected");
        String msg = "/ecp/" + userID + "/ecp/" + carparkIndex;
        data = msg.getBytes();
        c.send(data);
    }
}
