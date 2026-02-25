package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import model.Account;
import model.Transaction;

public class AccountController {
	
	public static void printAllAccounts(ArrayList<Account> accounts, ArrayList<Transaction> transactions) {
		System.out.println("There are: " + accounts.size() + " accounts in the system.");
		//System.out.println("Account_number | username_of_account_holder | account_type | account_opening_date");

		System.out.println(String.format("%-10s| %-30s| %-10s| %-15s| %-15s", 
				"Account #", "username_of_account_holder", "type", "opening_date", "Balance"));
		System.out.println("--------------------------------------------------------------------------------");
		
		for  (int i = 0; i < accounts.size(); i++) 
            System.out.println(accounts.get(i).toString() + "| $" + AccountController.getBalance(accounts.get(i).getAccount_number(), transactions, accounts));
		
		System.out.println();
	}
	
	public static double getBalance(String account_number, ArrayList<Transaction> transactions, ArrayList<Account> accounts) {
                // Check account exists
                if (!accountExists(account_number, accounts)) {
                        throw new IllegalArgumentException(
                                "Account does not exist: " + account_number);
                }
		double balance = 0.0;
		
		//loop through transactions
		for (int i = 0; i < transactions.size(); i++) {
			Transaction t = transactions.get(i);
			
			//check if transaction belongs to this account
			if (account_number.equals(t.getAccount_number())) {
                                 balance += t.getTransaction_amount();
                        }
		}
		return balance;
	}
	
	public static ArrayList<Account> loadAccountData() {
        ArrayList<Account> accounts = new ArrayList<>();
        Account anAccount;

        try {
            anAccount = new Account("5495-1234", "mike", "Standard",
                    new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019"));
            accounts.add(anAccount);

            anAccount = new Account("5495-1239", "mike", "Standard",
                    new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"));
            accounts.add(anAccount);

            anAccount = new Account("5495-1291", "mike", "Saving",
                    new SimpleDateFormat("dd/MM/yyyy").parse("21/07/2019"));
            accounts.add(anAccount);

            anAccount = new Account("5495-6789", "David.McDonald@gmail.com", "Saving",
                    new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019"));
            accounts.add(anAccount);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return accounts;
    }
	
        public static boolean accountExists(String accountNumber, ArrayList<Account> accounts) {

        for (Account account : accounts) {
                if (account.getAccount_number().equals(accountNumber)) {
                return true;   // match found
                }
        }

        return false;   // no match
        }

	public static void addTransaction(String account_number, double amount,
            ArrayList<Transaction> transactions, ArrayList<Account> accounts) {
                // Validate account
                if (!accountExists(account_number, accounts)) {
                        throw new IllegalArgumentException(
                                "Account does not exist: " + account_number);
                }

                // Check amount is not zero
                if (amount == 0.0) {
                        throw new IllegalArgumentException(
                        "Transaction amount cannot be zero.");
                }

		Transaction aTransaction = new Transaction(account_number, amount, Calendar.getInstance().getTime());
		transactions.add(aTransaction);
	}

        public static void transferFunds(String fromAccount,
                                 String toAccount,
                                 double amount,
                                 ArrayList<Account> accounts,
                                 ArrayList<Transaction> transactions) {

                // Validation
                if (!accountExists(fromAccount, accounts)) {
                        throw new IllegalArgumentException("Source account does not exist: " + fromAccount);
                }

                if (!accountExists(toAccount, accounts)) {
                        throw new IllegalArgumentException("Destination account does not exist: " + toAccount);
                }

                if (amount <= 0) {
                        throw new IllegalArgumentException("Transfer amount must be positive.");
                }

                // Check sufficient balance
                double balance = getBalance(fromAccount, transactions, accounts);
                if (balance < amount) {
                        throw new IllegalArgumentException("Insufficient funds in account: " + fromAccount);
                }

                // Perform transfer
                // Withdraw from source
                addTransaction(fromAccount, -amount, transactions, accounts);

                // Deposit to destination
                addTransaction(toAccount, amount, transactions, accounts);
                }
}
