/*
Class name: ChequingAccount.java  
Name:       Javier Nievas
Date:       2-Feb-2019
 
Description:  Description about the class 
 */
package nievasj;

/**
 *
 * @author Javier Nievas
 */
public class ChequingAccount extends Account implements Overdraftable {

    double overdraftAmount;
    
    public ChequingAccount() {
    }

    public ChequingAccount(String accountNumber, double accountBalance, String customerName) {
        super(accountNumber, accountBalance, customerName);
        this.interestRate = 1;
        this.overdraftAmount = 500;
    }

    @Override
    public void AccountWithdraw(double amount) {
        if (amount > (accountBalance+overdraftAmount)) {
            throw new IllegalArgumentException("Overdraft exceeded. "
                    + "Transaction canceled");
        }    
        withdrawAmount = amount; 
        this.accountBalance -= amount;
    }

 
    @Override
    public void setOverdraftAmount(double overdraftAmount) {
        this.overdraftAmount = overdraftAmount;
    }

    
}
