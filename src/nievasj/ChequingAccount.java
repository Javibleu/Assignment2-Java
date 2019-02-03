package nievasj;
/*
Class name: ChequingAccount.java  
Name:       Javier Nievas
Date:       2-Feb-2019
 
Description: Investmend Account is a subclass of Savings Account with a 1% of 
Interest Rate, this account can be Overdrafted up to $500.
 */
public class ChequingAccount extends Account implements Overdraftable {
   double overdraftAmount;
/**
 * Default empty Constructor
 */    
    public ChequingAccount() {
    }
/**
 * Constructor with Number, Balance and Customer Name arguments
 * @param accountNumber Account number identification
 * @param accountBalance Initial Balance of Account
 * @param customerName Customer Name 
 */
    public ChequingAccount(String accountNumber, double accountBalance, String customerName) {
        super(accountNumber, accountBalance, customerName);
        this.interestRate = 1;
        this.overdraftAmount = 500;
    }
/**
 * accountWithdraw Overrides Account abstract Method, this method do allows
 * to overdraft up to $500 therefore; the balance of this account 
 * can be negative. 
 * @param amount receive the amount to be withdrawn
 */
    @Override
    public void accountWithdraw(double amount) {
        if (amount > (accountBalance+overdraftAmount)) {
            throw new IllegalArgumentException("Overdraft exceeded. "
                    + "Transaction canceled");
        }    
        withdrawAmount = amount; 
        this.accountBalance -= amount;
    }
/**
 * Implements method from OverDraftable interface
 * @param overdraftAmount receives the value to be updated
 */
    @Override
    public void setOverdraftAmount(double overdraftAmount) {
        this.overdraftAmount = overdraftAmount;
    }

    
}
