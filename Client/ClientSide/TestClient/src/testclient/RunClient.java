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
public class RunClient {
    public void RunClient(){
    
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
            System.out.println("Username:");
            username = in.nextLine();
            System.out.println("Password:");
            password = in.nextLine();
            data = ("/c/" + username + "/c/" + password).getBytes();
            c.send(data);
            String recieved = c.recieve().trim();
            if (!recieved.equals("/c/-1")) {
                loggedIn = true;
                userID = Integer.parseInt(recieved.split("/c/")[1]);
                System.out.println("Great, you logged in!");
            }

        } while (!loggedIn);
        System.out.println("Select what you would like to do next");
        String pattern = "[1-2]{1}";
        do {
            System.out.println("1. Make a reservation.\n2. Enter a car park. (from the barrier)");
            input = in.nextLine();
            if (!input.matches(pattern)) {
                System.out.println("Input not valid, please enter 1 or 2");
            }
        } while (!input.matches(pattern));
        if (input.equals("1")) {
            makeReservation(userID, c);
        } else {
            enterCarPark(userID, c);
        }
    }

    private static void makeReservation(int userID, Client c) {
        Scanner in = new Scanner(System.in);
        byte[] data = new byte[1024];
        String[] times = {"00:00-05:59", "06:00-11:59", "12:00-17:59", "18:00-23:59"};
        int carparkIndex = getCarParkSelection(data, userID, c);
        int input = -1;
        while (input == -1) {
            System.out.println("Please enter a number to choose one of the following time periods");
            for (int i = 0; i < times.length; i++) {
                System.out.println((i + 1) + ") " + times[i]);
            }
            input = in.nextInt();
        }
        System.out.println("You entered: " + times[input - 1]);
        String msg = "/nrs/" + userID + "/nrs/" + carparkIndex + "/nrs/" + times[input - 1];
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
        System.out.println(recieved);
        if (recieved.startsWith("/ls/")) {
            carparks = recieved.split("/ls/");
        }
        System.out.println("Please select a car park:");
        for (int i = 1; i < carparks.length; i++) {
            System.out.println(i + ".\t" + carparks[i]);
        }
        while (carparkIndex == -1) {
            int input = in.nextInt();
            if (input >= 1 && input <= carparks.length) {
                carparkIndex = input - 1;
            } else {
                System.out.println("That was not a valid selection");
            }
        }
        return carparkIndex;
    }

    public static void enterCarPark(int userID, Client c) {
        Scanner in = new Scanner(System.in);
        byte[] data = new byte[1024];
        int carparkIndex = getCarParkSelection(data, userID, c);
        String msg = "/ecp/" + userID + "/ecp/" + carparkIndex;
        data = msg.getBytes();
        c.send(data);
    }

}
