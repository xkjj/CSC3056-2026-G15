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
	
	//////////////////////////////////////////////////////
	public static void main(String[] args) {
		
		users = UserController.loadUserData();
		// let's print them all to see if they have been loaded (populated) properly
		UserController.printAllUsers(users);
		
		accounts = AccountController.loadAccountData();
		// let's print them all to see if they have been loaded (populated) properly
		System.out.println("Accounts: initial state, after loading...");
		AccountController.printAllAccounts(accounts, transactions);
		
		// let's do some activities on the populated accounts, add transactions, etc.
		// Deposit: adding a transaction with a positive value
		// Withdraw: adding a transaction with a negative value
		AccountController.addTransaction("5495-1234", -50.21, transactions, accounts);
		System.out.println("Account: after the 1st addTransaction function call...");
		AccountController.printAllAccounts(accounts, transactions);
		
		// and some more activities on the accounts
		AccountController.addTransaction("5495-1234", 520.00, transactions, accounts);
		AccountController.addTransaction("9999-1111", 21.00, transactions, accounts); // it seems this account does not exist in the loaded (populated) data, 
											// but the addTransaction does not do that check, need to improve that function in future
		// let's print the accounts and their balance to see if the above transaction have impacted their balances
		System.out.println("Account: after the 2nd/3rd addTransaction function calls...");
		AccountController.printAllAccounts(accounts, transactions);
		
	}
}
