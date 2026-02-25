package utils;

public final class TestUtils {
	
	public static String TEXT_COLOR_GREEN = "\u001B[32m";
	public static String TEXT_COLOR_RED = "\u001B[31m";
	public static final String TEXT_COLOR_RESET = "\u001B[30m"; 
	
	public static void printTestPassed(String test_case_name) {
		System.out.println(TestUtils.TEXT_COLOR_GREEN + "PASSED -- " + test_case_name + TEXT_COLOR_RESET);
	}
	
	public static void printTestFailed(String test_case_name) {
		System.out.println(TestUtils.TEXT_COLOR_RED + "FAILED -- " + test_case_name + TEXT_COLOR_RESET);
	}

	public static void verifyEquals(String testName, int expected, int actual) {
    if (expected == actual)
        System.out.println(TestUtils.TEXT_COLOR_GREEN + testName + " passed" + TestUtils.TEXT_COLOR_RESET);
    else
        System.out.println(TestUtils.TEXT_COLOR_RED + testName + " FAILED" + TestUtils.TEXT_COLOR_RESET);
}

}
