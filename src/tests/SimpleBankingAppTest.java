package tests;

import app.SimpleBankingApp;
import utils.TestUtils;
import controller.AccountController;
import controller.UserController;

public class SimpleBankingAppTest {

    
	// system under test (SUT):
	//static SimpleBankingApp mainApp = new SimpleBankingApp ();

	// this test method (test case) verifies if the data load feature of the class (unit or component) 
	// under test (UUT) works properly
	public static void testLoadData() {
		// Reminder: the classical Four-Phase test pattern (Setup-Exercise-Verify-Teardown
		// http://xunitpatterns.com/Four%20Phase%20Test.html 
		
		// 1-Setup phase: none
		
		// 2-Exercise phase
		SimpleBankingApp.users = UserController.loadUserData();

		// 3-Verify phase
		// we see in the load function of the UUT that we have loaded 3 users, so let's verify that
		if (SimpleBankingApp.users.size() == 3)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadData: loadUserData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadData: loadUserData: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);

		// The above only verification is basic (simple, weak) 
		// To do STRONGER verification, we would need more assertions for user names and account balances, etc.
		
		SimpleBankingApp.accounts = AccountController.loadAccountData();
		if (SimpleBankingApp.accounts.size() == 4)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadData: loadAccountData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadData: loadAccountData: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		// 4-Teardown phase: if our goal was to only test the load, as Teardown (mainApp.accounts)
		// we would have deleted the loaded deleted from memory (variables users, and accounts), but we want
		// to use those data in the other tests, thus, we do not do any Teardown in this test case
	}
	
	public static void testDeposits() {
    	BalanceTestHelper.runBalanceChangeTest("5495-1234", 50.21, "testDeposits: TC1");
}

	public static void testWithdrawals() {
    	BalanceTestHelper.runBalanceChangeTest("5495-1234", -100, "testWithdrawals: TC1");
}
	
	public static void main(String[] args) {
		// we need to call our test cases (methods)
		testLoadData();
		testDeposits();
		testWithdrawals();
	}

}
