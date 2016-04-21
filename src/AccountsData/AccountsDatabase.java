    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountsData;

import Accounts.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aineb100
 */
public class AccountsDatabase {
    private ArrayList<User> users;
    
    public AccountsDatabase () {
        users = new ArrayList<>();
        try {
            File file = new File("src\\AccountsData\\users.txt");
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                    createUser(in.nextLine());
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("error: " +e);
        }
    }
    
    private void createUser(String line)
    {
        String [] parts = line.split(",");
        UserMaker user_maker = new UserMaker(
                Integer.parseInt(parts[0]), 
                Integer.parseInt(parts[1]), 
                parts[2], 
                parts[3], 
                parts[4], 
                parts[5]
        );
        
        users.add(user_maker.getUser());
    }
    
    public ArrayList<User> getUsers()
    {
        return this.users;
    }
    
    public void setUsers(ArrayList<User> users) {
        this.users.clear();
        this.users = users;
    }
    
    
    //to be called on destruction
    public void save() {
        if (users.size() >0 ) {
            try {
                PrintWriter writer = new PrintWriter("src\\AccountsData\\users.txt", "UTF-8");
                for (User my_user : users) {
                    writer.println(my_user.toString());
                }
                writer.close();
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                System.out.println("Error: " + e);
            }
        }
    }
}
