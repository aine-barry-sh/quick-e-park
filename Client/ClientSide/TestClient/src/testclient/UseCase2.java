/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclient;

// log in as staff

import java.util.Scanner;

// select lastest time
// select last car park in list
public class UseCase2 {
    public void UseCase2(){
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
            
            username = "alanM";
            
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
       
            System.out.println("1. Make a reservation.\n");
      
            makeReservation(userID, c);
        
    }

    private static void makeReservation(int userID, Client c) {
        Scanner in = new Scanner(System.in);
        byte[] data = new byte[1024];
        String[] times = {"00:00-05:59", "06:00-11:59", "12:00-17:59", "18:00-23:59"};
        int carparkIndex = getCarParkSelection(data, userID, c);
        System.out.println("Car park 11) peterpeter selected");
       
        System.out.println("You entered: " + times[1 - 1]);
        String msg = "/nrs/" + userID + "/nrs/" + carparkIndex + "/nrs/" + times[1 - 1];
        data = msg.getBytes();
        c.send(data);
    }

    private static int getCarParkSelection(byte[] data, int userID, Client c) {
        Scanner in = new Scanner(System.in);
        String[] carparks = new String[0];
        int carparkIndex = -1;
        data = ("/gcp/" + userID + "/gcp/").getBytes();
        c.send(data);
        String recieved = c.recieve().trim();
        //System.out.println(recieved);
        if (recieved.startsWith("/ls/")) {
            carparks = recieved.split("/ls/");
        }
        
        carparkIndex = 1;
        return carparkIndex;
    }
}
