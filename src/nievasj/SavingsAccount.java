package nievasj;
/*
Class name: SavingsAccount.java  
Name:       Javier Nievas
Date:       2-Feb-2019
 
Description: Savings Account is a subclass of Account with a 2% of 
Interest Rate, it cannot  be Overdrafted.
 */
public class SavingsAccount extends Account {
/**
 * Default empty Constructor
 */
    public SavingsAccount() {
    }
/**
 * Constructor with Number, Balance and Customer Name arguments
 * @param accountNumber Account number identification
 * @param accountBalance Initial Balance of Account
 * @param customerName Customer Name
 */
    public SavingsAccount(String accountNumber, double accountBalance, String customerName) {
        super(accountNumber, accountBalance, customerName);
        this.interestRate = 2;
    }
     
/**
 * accountWithdraw Overrides Account abstract Method, this method do not allow
 * to overdraft, the balance of this account cannot be negative. 
 * 
 * @param amount receive the amount to be withdrawn
 */
        @Override
    public void accountWithdraw(double amount) {
        if (amount > accountBalance) {
            throw new IllegalArgumentException("Overdraft exceeded. "
                    + "Transaction canceled");
        }    
        withdrawAmount = amount; 
        this.accountBalance -= amount;
    }
}
