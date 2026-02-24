package app;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;

import model.Account;
import model.Transaction;
import model.User;
import controller.AccountController;
import controller.UserController;

public class SimpleBankingApp {
	public static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<Account> accounts  = new ArrayList<Account>();
	public static ArrayList<Transaction> transactions =  new ArrayList<Transaction>();
	
	public static void printAllUsers() {
		System.out.println("There are: " + users.size() + " users in the system.");	
		System.out.println(String.format("%-25s| %-15s| %-15s| %-15s| %-15s", 
				"username", "password", "first_name", "last_name", "mobile_number"));
		System.out.println("-------------------------------------------------------------------------------------------");
		for  (int i = 0; i < users.size(); i++) 
            System.out.println(users.get(i).toString());	
		System.out.println();
	}
	
	public static void printAllAccounts() {
		System.out.println("There are: " + accounts.size() + " accounts in the system.");
		//System.out.println("Account_number | username_of_account_holder | account_type | account_opening_date");

		System.out.println(String.format("%-10s| %-30s| %-10s| %-15s| %-15s", 
				"Account #", "username_of_account_holder", "type", "opening_date", "Balance"));
		System.out.println("--------------------------------------------------------------------------------");
		
		for  (int i = 0; i < accounts.size(); i++) 
            System.out.println(accounts.get(i).toString() + "| $" + AccountController.getBalance(accounts.get(i).getAccount_number(), transactions));
		
		System.out.println();
	}
	
	//////////////////////////////////////////////////////
	public static void main(String[] args) {
		
		users = UserController.loadUserData();
		// let's print them all to see if they have been loaded (populated) properly
		printAllUsers();
		
		accounts = AccountController.loadAccountData();
		// let's print them all to see if they have been loaded (populated) properly
		System.out.println("Accounts: initial state, after loading...");
		printAllAccounts();
		
		// let's do some activities on the populated accounts, add transactions, etc.
		// Deposit: adding a transaction with a positive value
		// Withdraw: adding a transaction with a negative value
		AccountController.addTransaction("5495-1234", -50.21, transactions, accounts);
		System.out.println("Account: after the 1st addTransaction function call...");
		printAllAccounts();
		
		// and some more activities on the accounts
		AccountController.addTransaction("5495-1234", 520.00, transactions, accounts);
		AccountController.addTransaction("9999-1111", 21.00, transactions, accounts); // it seems this account does not exist in the loaded (populated) data, 
											// but the addTransaction does not do that check, need to improve that function in future
		// let's print the accounts and their balance to see if the above transaction have impacted their balances
		System.out.println("Account: after the 2nd/3rd addTransaction function calls...");
		printAllAccounts();
		
	}
}
