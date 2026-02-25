package tests;

import model.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import utils.TestUtils;

public class TransactionTest {

	public static void main(String[] args) throws ParseException {
		testTransactionConstructor();

	}
	
	public static void testTransactionConstructor() throws ParseException {
		//automated testing
				//1 - Setup
				String test_account_number = "123456";
				double test_transaction_amount = 10.0;
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //SimpleDateFormat used so date can be displayed in dd/mm/yyyy
				Date test_transaction_date = sdf.parse("21/02/2026");
	
				
				//2 - Exercise, run the object under test (constructor)
				Transaction testTransaction = new Transaction (test_account_number, test_transaction_amount, test_transaction_date);
				
				//3 - Verify (assert)
				System.out.println("Starting the assertions of the test method: testTransactionConstructor");
				
				String test_case_name = "TC1-getAccount_number";
				if (testTransaction.getAccount_number() == test_account_number)
					TestUtils.printTestPassed(test_case_name);
				else
					TestUtils.printTestFailed(test_case_name);
				
				String test_case_name2 = "TC2-getTransaction_amount";
				if (testTransaction.getTransaction_amount() == test_transaction_amount)
					TestUtils.printTestPassed(test_case_name2);
				else
					TestUtils.printTestFailed(test_case_name2);
				
				String test_case_name3 = "TC3-getTransaction_date";
				if (testTransaction.getTransaction_date() == test_transaction_date)
					TestUtils.printTestPassed(test_case_name3);
				else
					TestUtils.printTestFailed(test_case_name3);

				//using assertions
				assert testTransaction.getAccount_number() == test_account_number;
				assert testTransaction.getTransaction_amount() == test_transaction_amount;
				assert testTransaction.getTransaction_date() == test_transaction_date;

				System.out.println("All Java assertions in the test suit passed (none failed).");
	}

}
