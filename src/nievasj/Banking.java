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

    //static double depositInput;     //Keeps the value entered to be processed
    //static double withdrawInput;    //Keeps the value entered to be processed
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
        System.out.printf("%s %9s %9s %7s %9s\n", "AccNo", "Deposit", "WithDraw", "Intr.", "Newbal");
        System.out.println("===========================================");
    }

    /**
     * Call input and check if the number entered is negative or not a number.
     * @param operation string that will used to build prompt message
     * @return the input value entered by operator after Validation
     */
    public static double validInput(String operation) {
        boolean cont;       //flag to keep into loop or get out of it
        double input = 0.0;
        do {
            try {
                input = (promptClient("Enter amount you want to" + operation));
                cont = false;       //to go out of loop
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                cont = true;    //continue into the loop asking for correct data
            } catch (InputMismatchException f) {
                System.out.println("Error: The value entered is not a number");
                cont = true;    //continue into the loop asking for correct data

            }

        } while (cont);
        return input;
    }// end of validDeposit Method
   

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
    }

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
