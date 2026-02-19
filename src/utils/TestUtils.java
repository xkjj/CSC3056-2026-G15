package utils;

public final class TestUtils {
	
	public static String TEXT_COLOR_GREEN = "\u001B[32m";
	public static String TEXT_COLOR_RED = "\u001B[31m";
	public static final String TEXT_COLOR_RESET = "\u001B[30m"; 
	
	public static void printTestPassed(String test_case_name) {
		System.out.println(TestUtils.TEXT_COLOR_GREEN + "PASSED -- " + test_case_name);
	}
	
	public static void printTestFailed(String test_case_name) {
		System.out.println(TestUtils.TEXT_COLOR_RED + "FAILED --" + test_case_name);
	}
}
