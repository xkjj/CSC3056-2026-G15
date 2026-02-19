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
				
				
		
	}
}
