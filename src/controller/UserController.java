package controller;

import java.util.ArrayList;
import model.User;

public class UserController{

	public static ArrayList<User> loadUserData() {
		// structure of each record: username (email address), password, first_name, last_name, mobile_number

        ArrayList<User> users = new ArrayList<>(); 
        User aUser = new User("mike", "my_passwd", "Mike", "Smith", "07771234567");
		users.add(aUser);
		
		aUser = new User("james.cameron@gmail.com", "angel", "James", "Cameron",  "07777654321");
		users.add(aUser);
		
		aUser = new User("julia.roberts@gmail.com", "change_me",   "Julia", "roberts",   "07770123456");
		users.add(aUser); 

        return users;
	}
	
	public static void printAllUsers(ArrayList<User> users) {
		System.out.println("There are: " + users.size() + " users in the system.");	
		System.out.println(String.format("%-25s| %-15s| %-15s| %-15s| %-15s", 
				"username", "password", "first_name", "last_name", "mobile_number"));
		System.out.println("-------------------------------------------------------------------------------------------");
		for  (int i = 0; i < users.size(); i++) 
            System.out.println(users.get(i).toString());	
		System.out.println();
	}
	
	
}