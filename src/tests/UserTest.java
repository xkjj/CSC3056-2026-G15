package tests;

import model.User;
import utils.TestUtils;

public class UserTest {

	public static void main(String[] args) {
		testUserConstructor();
	}

	public static void testUserConstructor() {
		//automated testing
				//1 - Setup
				String test_username = "mike";
				String test_password = "my_passwd";
				String test_first_name = "Mike";
				String test_last_name = "Smith";
				String test_mobile_number = "07771234567";
				
				//2 - Exercise, run the object under test (constructor)
				User testUser = new User (test_username, test_password, test_first_name,
						test_last_name, test_mobile_number);
				
				//3 - Verify (assert)
				System.out.println("Starting the assertions of the test method: testUserConstructor");
				
				String test_case_name = "TC1-getUsername";
				if (testUser.getUsername() == test_username)
				//old: before refactoring
				//System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getUsername-Passed"+ TestUtils.TEXT_COLOR_RESET);
				//new: after refactoring
					TestUtils.printTestPassed(test_case_name);
				else
				//old: before refactoring
				//System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getUsername-Failed"+ TestUtils.TEXT_COLOR_RESET);
				//new: after refactoring
					TestUtils.printTestFailed(test_case_name);
				
				String test_case_name2 = "TC2-getPassword";
				if (testUser.getPassword() == test_password)
					TestUtils.printTestPassed(test_case_name2);
				else
					TestUtils.printTestFailed(test_case_name2);
				
				String test_case_name3 = "TC3-getFirst_name";
				if (testUser.getFirst_name() == test_first_name)
					TestUtils.printTestPassed(test_case_name3);
				else
					TestUtils.printTestFailed(test_case_name3);
				
				String test_case_name4 = "TC4-getLast_name";
				if (testUser.getLast_name() == test_last_name)
					TestUtils.printTestPassed(test_case_name4);
				else
					TestUtils.printTestFailed(test_case_name4);
				
				String test_case_name5 = "TC5-getMobile_number";
				if (testUser.getMobile_number() == test_mobile_number)
					TestUtils.printTestPassed(test_case_name5);
				else
					TestUtils.printTestFailed(test_case_name5);
				
				//using assertions
				assert testUser.getUsername() == test_username;
				assert testUser.getPassword() == test_password;
				assert testUser.getFirst_name() == test_first_name;
				assert testUser.getLast_name() == test_last_name;
				assert testUser.getMobile_number() == test_mobile_number;
								
				System.out.println("All Java assertions in the test suit passed (none failed).");
	}
}
