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

    static double depositInput;
    static double withdrawInput;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ChequingAccount account101 = new ChequingAccount("101", 1000, "Carlos");
        SavingsAccount account201 = new SavingsAccount("201", 1000, "Carlos");
        InvestmentAccount account301 = new InvestmentAccount("301", 1000, "Carlos");

        validDeposit();
        validWithdraw();

        printTitle(account101);
        
        executeTransactions(account101);
        executeTransactions(account201);
        executeTransactions(account301);
        

    }

    public static void printTitle(ChequingAccount a) {
        System.out.println("Customer: " + a.customerName);
        System.out.println("===========================================");
        System.out.printf("%s %9s %9s %7s %9s\n", "AccNo", "Deposit", "WithDraw", "Intr", "Newbal");
        System.out.println("===========================================");
    }

    public static void validDeposit() {
        boolean cont;       //flag to keep into loop or get out of it
        do {
            try {
                depositInput = (promptClient("Enter amount you want to deposit:"));
                cont = false;       //to go out of loop
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                cont = true;    //continue into the loop asking for correct data
            } catch (InputMismatchException f) {
                System.out.println("Error: The value entered is not a number");
                cont = true;    //continue into the loop asking for correct data

            }

        } while (cont);

    }

    public static void validWithdraw() {
        boolean cont;       //flag to keep into loop or get out of it
        do {
            try {
                withdrawInput = (promptClient("Enter amount you want to withdraw: "));
                cont = false;       //to go out of loop
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                cont = true;    //continue into the loop asking for correct data
            } catch (InputMismatchException f) {
                System.out.println("Error: The value entered is not a number");
                cont = true;    //continue into the loop asking for correct data

            }

        } while (cont);

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

    public static void executeTransactions(Account account) {
        account.AccountDeposit(depositInput);
        try {
            account.AccountWithdraw(withdrawInput);
        } catch (IllegalArgumentException a) {
            System.out.println(a.getMessage());
        }
        System.out.println(account);
    }

}
