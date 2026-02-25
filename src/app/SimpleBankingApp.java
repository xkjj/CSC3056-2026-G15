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
		UserController.printAllUsers(users);
		
		accounts = AccountController.loadAccountData();
		System.out.println("Accounts: initial state, after loading...");
		AccountController.printAllAccounts(accounts, transactions);
		
		// Deposit: adding a transaction with a positive value
		// Withdraw: adding a transaction with a negative value
		AccountController.addTransaction("5495-1234", -50.21, transactions, accounts);
		//AccountController.addTransaction("5495-1291", 0, transactions, accounts); //  adding 0 amount transaction
		System.out.println("Account: after the 1st addTransaction function call...");
		AccountController.printAllAccounts(accounts, transactions);
		
		AccountController.addTransaction("5495-1234", 520.00, transactions, accounts);
		//AccountController.addTransaction("9999-1111", 21.00, transactions, accounts); // adding transaction for invalid account
									
		System.out.println("Account: after the 2nd/3rd addTransaction function calls...");
		AccountController.printAllAccounts(accounts, transactions);

		System.out.println("Transferring $100 from 5495-1234 to 5495-1239...");
		AccountController.transferFunds("5495-1234", "5495-1239", 100.0, accounts, transactions);
		AccountController.printAllAccounts(accounts, transactions);
	}
}
