package tests;

import app.SimpleBankingApp;
import controller.AccountController;
import utils.TestUtils;

public class BalanceTestHelper {

    public static void runBalanceChangeTest(String accountNumber, double amount, String testName) {

        // 1-Setup
        double balanceBefore = AccountController.getBalance(accountNumber, SimpleBankingApp.transactions);

        // 2-Exercise
        AccountController.addTransaction(accountNumber, amount, SimpleBankingApp.transactions, SimpleBankingApp.accounts);

        double balanceAfter = AccountController.getBalance(accountNumber, SimpleBankingApp.transactions);

        // 3-Verify
        assert balanceBefore + amount == balanceAfter;

        if (balanceBefore + amount == balanceAfter)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + testName + " passed" + TestUtils.TEXT_COLOR_RESET);
        else {
            System.out.println(TestUtils.TEXT_COLOR_RED + testName + " FAILED" + TestUtils.TEXT_COLOR_RESET);
            System.out.format("balanceBefore = %.2f ; amount = %.2f ; balanceAfter = %.2f %s\n",
                    balanceBefore, amount, balanceAfter, TestUtils.TEXT_COLOR_RESET);
        }

        // 4-Tear-down
        AccountController.addTransaction(accountNumber, -amount, SimpleBankingApp.transactions, SimpleBankingApp.accounts);
    }
}