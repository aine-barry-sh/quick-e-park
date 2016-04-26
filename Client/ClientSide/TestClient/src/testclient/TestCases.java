/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclient;

/**
 *
 * @author ZeCaptain
 */
import java.util.Scanner;


// 1) log in as a student, select car park 1, reserve a space at the earliest time
// 2) log in as a staff user, select car park 3(or whatever the last one is), then reserve a space at the latest time
// 3) create a new user
// 4) Arriving at the car park
public class TestCases {

    public  void TestCases() {
        Client c = new Client("James", "127.0.0.1", 41122);
        c.openConnection("127.0.0.1");
        int userID = 0;

        System.out.println("This application runs a series of test cases on the server");

        System.out.println("Test 1:\n Login as a student, reserve a space in the first car park ");
        byte[] data = ("/c/james/c/pass12").getBytes();
        c.send(data);
        String recieved = c.recieve().trim();
        if (recieved.equals("/c/-1")) {
            System.out.println("Login unsuccessful");
        } else {
            userID= Integer.parseInt(recieved.split("/c/")[1]);
            String msg = "/nrs/" +userID + "/nrs/1/nrs/00:00-05:59";
            data = msg.getBytes();
            c.send(data);
            System.out.println("Reservation sent to server\n\n");
        }

        System.out.println("Test 2:\nLogin as staff member, select carpark 3");
        data = ("/c/mw/c/password").getBytes();
        c.send(data);
        recieved = c.recieve().trim();
        if (recieved.equals("/c/-1")) {
            System.out.println("Login unsuccessful");
        } else {
               userID= Integer.parseInt(recieved.split("/c/")[1]);
            String msg = "/nrs/" + Integer.parseInt(recieved.split("/c/")[1]) + "/nrs/3/nrs/18:00-23:59";
            data = msg.getBytes();
            c.send(data);
            System.out.println("Reservation sent to server, check reservations.txt to confirm\n\n");
        }

        //test 3
        
        
        System.out.println("Test 4: Arriving at car park");
        data = new byte[1024];
        int carparkIndex = getCarParkSelection(data, userID, c);
        String msg = "/ecp/" + userID + "/ecp/" + carparkIndex;
        System.out.println(msg);
        data = msg.getBytes();
        c.send(data);
        System.out.println("User added to car park, check server logs to confirm");

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
}
