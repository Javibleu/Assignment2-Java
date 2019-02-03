/*
Class name: SavingsAccount.java  
Name:       Javier Nievas
Date:       2-Feb-2019
 
Description:  Description about the class 
 */
package nievasj;

/**
 *
 * @author Javier Nievas
 */
public class SavingsAccount extends Account {

    public SavingsAccount() {
    }

    public SavingsAccount(String accountNumber, double accountBalance, String customerName) {
        super(accountNumber, accountBalance, customerName);
        this.interestRate = 2;
    }
    
    

        @Override
    public void AccountWithdraw(double amount) {
        if (amount > accountBalance) {
            throw new IllegalArgumentException("Overdraft exceeded. "
                    + "Transaction canceled");
        }    
        withdrawAmount = amount; 
        this.accountBalance -= amount;
    }

  

   

}
