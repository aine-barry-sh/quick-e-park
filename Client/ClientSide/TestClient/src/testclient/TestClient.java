/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclient;

import java.util.Scanner;

/**
 *
 * @author jconn
 */
public class TestClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
    
        
        int x = -1;
        
        Scanner input = new Scanner(System.in);
        boolean Running = true;
        while(Running == true){
        System.out.println("Would you like to Run the program or Run a use case? \n0) Program \n1) Use Case 1 \n2) Use Case 2 \n3) Use Case 3 \n4) Use Case 4 \n5) More Test Cases");
        
        try{
         x = Integer.parseInt(input.next());
        }
        catch(NumberFormatException e)
        {
            System.out.println("Invalid Input");
        }
         if(x == 0)
            {
                Running = false;
                RunClient rc = new RunClient();
                rc.RunClient();
            }
         else if(x == 1)
         {
             Running = false;
             UseCase1 uc1 = new UseCase1();
             uc1.UseCase1();
         }
         else if(x == 2)
         {
             Running = false;
             UseCase2 uc2 = new UseCase2();
             uc2.UseCase2();
         
         }
         else if(x == 3)
         {
         
             Running = false;
             UseCase3 uc3 = new UseCase3();
             uc3.UseCase3();
         
         }
         else if(x == 4)
         {
         
             Running = false;
             UseCase4 uc4 = new UseCase4();
             uc4.UseCase4();
         
         }
         else if (x == 5)
         {
             Running = false;
             TestCases tc = new TestCases();
             tc.TestCases();
         
         }
         else
         {
             System.out.println("Invalid option");
             Running = true;
         }
        }
        
        
    }
       
}
