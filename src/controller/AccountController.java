package controller;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import java.text.ParseException;

import model.Account;
import model.Transaction;

public class AccountController {
	
	public static double getBalance(String account_number, ArrayList<Transaction> transactions) {
		double balance = 0.0;
		
		//loop through transactions
		for (int i = 0; i < transactions.size(); i++) {
			Transaction t = transactions.get(i);
			
			//check if transaction belongs to this account
			if (t.getAccount_number() == account_number) {
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
                System.out.println("ERROR: Account does not exist: " + account_number);
                return;
         }

		Transaction aTransaction = new Transaction(account_number, amount, Calendar.getInstance().getTime());
		transactions.add(aTransaction);
	}
}
