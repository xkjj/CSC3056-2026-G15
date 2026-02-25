package tests;

import app.SimpleBankingApp;
import utils.TestUtils;
import controller.AccountController;
import controller.UserController;

public class SimpleBankingAppTest {

    private static final String TEST_ACCOUNT_NUMBER = "5495-1234";
   
    public static void testLoadUserAndAccountData() {
   
        SimpleBankingApp.users = UserController.loadUserData();

        TestUtils.verifyEquals("testLoadData: loadUserData: TC1", 3, SimpleBankingApp.users.size());

        SimpleBankingApp.accounts = AccountController.loadAccountData();

        TestUtils.verifyEquals("testLoadData: loadAccountData: TC2", 4, SimpleBankingApp.accounts.size());
    }
   
    public static void testDeposits() {
        BalanceTestHelper.runBalanceChangeTest(TEST_ACCOUNT_NUMBER, 50.21, "testDeposits: TC3");
    }

    public static void testWithdrawals() {
        BalanceTestHelper.runBalanceChangeTest(TEST_ACCOUNT_NUMBER, -100, "testWithdrawals: TC4");
}

public static void testAddTransaction_ZeroAmount() {

    // Setup
    SimpleBankingApp.accounts = AccountController.loadAccountData();

    try {
        // Exercise
        AccountController.addTransaction("5945-1234", 0.0, SimpleBankingApp.transactions, SimpleBankingApp.accounts);

        // If no exception → fail
        System.out.println(TestUtils.TEXT_COLOR_RED + "testAddTransaction_ZeroAmount: TC5 FAILED (no exception)" + TestUtils.TEXT_COLOR_RESET);

    } catch (IllegalArgumentException e) {
        // Expected
        System.out.println(TestUtils.TEXT_COLOR_GREEN + "testAddTransaction_ZeroAmount: TC5 passed" + TestUtils.TEXT_COLOR_RESET);
    }
}

public static void testAddTransaction_InvalidAccount() {

    SimpleBankingApp.accounts = AccountController.loadAccountData();

    try {
        AccountController.addTransaction("9999-1111", 50.0, SimpleBankingApp.transactions, SimpleBankingApp.accounts);

        System.out.println(TestUtils.TEXT_COLOR_RED + "testAddTransaction_InvalidAccount: TC6 FAILED" + TestUtils.TEXT_COLOR_RESET);

    } catch (IllegalArgumentException e) {
        System.out.println(TestUtils.TEXT_COLOR_GREEN + "testAddTransaction_InvalidAccount: TC6 passed" + TestUtils.TEXT_COLOR_RESET);
    }
}

public static void testGetBalance_InvalidAccount() {

    SimpleBankingApp.accounts = AccountController.loadAccountData();

    try {
        AccountController.getBalance("9999-1111", SimpleBankingApp.transactions, SimpleBankingApp.accounts);

        System.out.println(TestUtils.TEXT_COLOR_RED + "testGetBalance_InvalidAccount: TC7 FAILED" + TestUtils.TEXT_COLOR_RESET);

    } catch (IllegalArgumentException e) {
        System.out.println(TestUtils.TEXT_COLOR_GREEN + "testGetBalance_InvalidAccount: TC7 passed" + TestUtils.TEXT_COLOR_RESET);
    }
}

public static void testTransferFunds() {

    // Setup
    SimpleBankingApp.accounts = AccountController.loadAccountData();

    // Give source account money
    AccountController.addTransaction("5495-1234", 200.0,
            SimpleBankingApp.transactions,
            SimpleBankingApp.accounts);

    double beforeFrom = AccountController.getBalance(
            "5495-1234",
            SimpleBankingApp.transactions,
            SimpleBankingApp.accounts);

    double beforeTo = AccountController.getBalance(
            "5495-1239",
            SimpleBankingApp.transactions,
            SimpleBankingApp.accounts);

    // Exercise
    AccountController.transferFunds(
            "5495-1234",
            "5495-1239",
            100.0,
            SimpleBankingApp.accounts,
            SimpleBankingApp.transactions);

    double afterFrom = AccountController.getBalance(
            "5495-1234",
            SimpleBankingApp.transactions,
            SimpleBankingApp.accounts);

    double afterTo = AccountController.getBalance(
            "5495-1239",
            SimpleBankingApp.transactions,
            SimpleBankingApp.accounts);

    // Verify
    if (afterFrom == beforeFrom - 100.0 &&
        afterTo == beforeTo + 100.0)
        System.out.println(TestUtils.TEXT_COLOR_GREEN + "testTransferFunds: TC8 passed" + TestUtils.TEXT_COLOR_RESET);
    else
        System.out.println(TestUtils.TEXT_COLOR_RED + "testTransferFunds: TC8 FAILED" + TestUtils.TEXT_COLOR_RESET);
}

    public static void main(String[] args) {
        // we need to call our test cases (methods)
        testLoadUserAndAccountData();
        testDeposits();
        testWithdrawals();
        testAddTransaction_InvalidAccount();
        testAddTransaction_ZeroAmount();
        testGetBalance_InvalidAccount();
        testTransferFunds();
    }

}