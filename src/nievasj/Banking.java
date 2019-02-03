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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ChequingAccount account101 = new ChequingAccount("101", 1000, "Carlos");
        SavingsAccount account201 = new SavingsAccount("201", 1000, "Carlos");
        InvestAccount account301 = new InvestAccount("301", 1000, "Carlos");

        double depositInput = validDeposit();                 //Call Input and Validation Method
        double depositWithdraw= validWithdraw();                //Call Input and Validation Method
        printHeaderTable(account101);   //Print Client name and Table's Header
        executeTransactions(account101,depositInput,depositWithdraw);//Process 
        executeTransactions(account201,depositInput,depositWithdraw);//Process 
        executeTransactions(account301,depositInput,depositWithdraw);//Process 
        
    }// main end

    public static void printHeaderTable(ChequingAccount a) {
        System.out.println("Customer: " + a.customerName);
        System.out.println("===========================================");
        System.out.printf("%s %9s %9s %7s %9s\n", "AccNo", "Deposit", "WithDraw", "Intr.", "Newbal");
        System.out.println("===========================================");
    }
/**
 * Call input and check if the number entered is negative or not a number.
 */
    public static double validDeposit() {
        boolean cont;       //flag to keep into loop or get out of it
        double input= 0.0;
        do {
            try {
               input = (promptClient("Enter amount you want to deposit:"));
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
    }

    public static double validWithdraw() {
        boolean cont;       //flag to keep into loop or get out of it
        double input= 0.0;
        do {
            try {
                input = (promptClient("Enter amount you want to withdraw: "));
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
    }

    
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
            double depositInput, double withdrawInput ) {
        account.AccountDeposit(depositInput);
        try {
            account.AccountWithdraw(withdrawInput);
        } catch (IllegalArgumentException a) {
            System.out.println(a.getMessage());
        }
        System.out.println(account);
    }

}
