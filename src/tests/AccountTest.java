package tests;

import model.Account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import utils.TestUtils;

public class AccountTest {

	public static void main(String[] args) throws ParseException {
		testAccountConstructor();
	}
	
		public static void testAccountConstructor() throws ParseException {
			//automated testing
					//1 - Setup
					String test_account_number = "123456";
					String test_username_of_account_holder = "mike@yahoo.com";
					String test_account_type = "Standard";
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //SimpleDateFormat used so date can be displayed in dd/mm/yyyy
					Date test_account_opening_date = sdf.parse("20/02/2026");
		
					
					//2 - Exercise, run the object under test (constructor)
					Account testAccount = new Account (test_account_number, test_username_of_account_holder, test_account_type,
							test_account_opening_date);
					
					//3 - Verify (assert)
					System.out.println("Starting the assertions of the test method: testAccountConstructor");
					
					String test_case_name = "TC1-getAccount_number";
					if (testAccount.getAccount_number() == test_account_number)
						TestUtils.printTestPassed(test_case_name);
					else
						TestUtils.printTestFailed(test_case_name);
					
					String test_case_name2 = "TC2-getUsername_of_account_holder";
					if (testAccount.getUsername_of_account_holder() == test_username_of_account_holder)
						TestUtils.printTestPassed(test_case_name2);
					else
						TestUtils.printTestFailed(test_case_name2);
					
					String test_case_name3 = "TC3-getAccount_type";
					if (testAccount.getAccount_type() == test_account_type)
						TestUtils.printTestPassed(test_case_name3);
					else
						TestUtils.printTestFailed(test_case_name3);
					
					String test_case_name4 = "TC4-getAccount_opening_date";
					if (testAccount.getAccount_opening_date() == test_account_opening_date)
						TestUtils.printTestPassed(test_case_name4);
					else
						TestUtils.printTestFailed(test_case_name4);

					//using assertions
					assert testAccount.getAccount_number() == test_account_number;
					assert testAccount.getUsername_of_account_holder() == test_username_of_account_holder;
					assert testAccount.getAccount_type() == test_account_type;
					assert testAccount.getAccount_opening_date() == test_account_opening_date;

					System.out.println("All Java assertions in the test suit passed (none failed).");
		}

}
