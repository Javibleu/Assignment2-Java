/* 
Name:       Javier Nievas 
Assignment: Assignment(******************)
Program:    PROG24178 
Date:       2-Feb-2019
 
Description: [program description in your own words] 
 */
package nievasj;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Javier Nievas
 */
public class Banking {

    /**
     * Main Method: create Objects and Call Methods to Validate and process
     * transactions
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ChequingAccount account101 = new ChequingAccount("101", 1000, "Carlos");
        SavingsAccount account201 = new SavingsAccount("201", 1000, "Carlos");
        InvestAccount account301 = new InvestAccount("301", 1000, "Carlos");
        //Call Input and Validation Methods to deposit and withdraw 
        double depositInput = validInput(" deposit: ");
        double depositWithdraw = validInput(" witdraft: ");
        //Print Client name and Table's Header
        printHeaderTable(account101);
        // Each one call process deposit and withdraw transactions
        executeTransactions(account101, depositInput, depositWithdraw);
        executeTransactions(account201, depositInput, depositWithdraw);
        executeTransactions(account301, depositInput, depositWithdraw);

    }// main end

    /**
     * Prints the name of Client and a Table Header with the titles
     *
     * @param a receive the Chequing Account Object to obtain the Name of Client
     */
    public static void printHeaderTable(ChequingAccount a) {
        System.out.println("Customer: " + a.customerName);
        System.out.println("===========================================");
        System.out.printf("%s %7s %9s %7s %9s\n", "AccNo.", "Deposit",
                "Withdraw", "Intr.", "NewBal");
        System.out.println("===========================================");
    }

    /**
     * Call input and check if the number entered is negative or not a number.
     *
     * @param operation string that will used to build prompt message
     * @return the input value entered by operator after validation
     */
    public static double validInput(String operation) {
        boolean cont = true;       //flag to keep into loop or get out of it
        double input = 0.0;
        do {
            try {
                input = (promptClient("Enter amount you want to" + operation));
                cont = false;       //with no exceptions trowed, go out of loop
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException f) {
                System.out.println("Error: The value entered is not a number");
            }
        } while (cont);
        return input;
    }// end of validDeposit Method

    /**
     * Print prompt on Screen and check value
     *
     * @param prompt to receive the String that will be printed on Screen
     * @return double after check if it is no a negative number
     */
    public static double promptClient(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        double input = sc.nextDouble();
        if (input >= 0) {
            return input;
        } else {
            throw new IllegalArgumentException("Error: This is a negative "
                    + "number");
        }
    }// Ends PromptClient method

    /**
      Method that executes transactions on Accounts
     * @param account Object on with will be executed the transaction
     * @param depositInput Amount of money that will be deposited
     * @param withdrawInput Amount of money that will be withdraw
     */
    public static void executeTransactions(Account account,
            double depositInput, double withdrawInput) {
        account.AccountDeposit(depositInput);
        try {
            account.AccountWithdraw(withdrawInput);
        } catch (IllegalArgumentException a) {
            System.out.println(a.getMessage());
        }
        System.out.println(account);
    }

}
