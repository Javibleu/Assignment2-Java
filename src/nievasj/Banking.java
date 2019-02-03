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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ChequingAccount account101 = new ChequingAccount("101", 1000, "Carlos");
        SavingsAccount account201 = new SavingsAccount("201", 1000, "Carlos");
        InvestmentAccount account301 = new InvestmentAccount("301", 1000, "Carlos");

        enterDeposit(account101, account201, account301);
        enterWithdraw(account101, account201, account301);

        printTitle(account101);
        System.out.println(account101);
        System.out.println(account201);
        System.out.println(account301);

    }

    public static void printTitle(ChequingAccount a) {
        System.out.println("Customer: " + a.customerName);
        System.out.println("===========================================");
        System.out.printf("%s %9s %9s %7s %9s\n", "AccNo", "Deposit", "WithDraw", "Intr", "Newbal");
        System.out.println("===========================================");
    }

    public static void enterDeposit(Account a, Account b ,Account c) {
        double value = 0;
        boolean cont;       //flag to keep into loop or get out of it
        do {
            try {
                value = (promptClient("Enter amount you want to deposit:"));
                cont = false;       //to go out of loop
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                cont = true;    //continue into the loop asking for correct data
            } catch (InputMismatchException f) {
                System.out.println("Error: The value entered is not a number");
                cont = true;    //continue into the loop asking for correct data

            }

        } while (cont);
    
            a.AccountDeposit(value);
            b.AccountDeposit(value);
            c.AccountDeposit(value);
          
        }
        

    
        public static void enterWithdraw(Account a, Account b ,Account c) {
        double value = 0;
        boolean cont;       //flag to keep into loop or get out of it
        do {
            try {
                value = (promptClient("Enter amount you want to withdraw: "));
                cont = false;       //to go out of loop
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                cont = true;    //continue into the loop asking for correct data
            } catch (InputMismatchException f) {
                System.out.println("Error: The value entered is not a number");
                cont = true;    //continue into the loop asking for correct data

            }

        } while (cont);
        
            try{ 
             a.AccountWithdraw(value);
             } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            }
            try{ 
             b.AccountWithdraw(value);
             } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            }try{ 
             c.AccountWithdraw(value);
             } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            }
         
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
}
