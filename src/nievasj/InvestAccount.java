package nievasj;
/*
Class name: InvestAccount.java  
Name:       Javier Nievas
Date:       2-Feb-2019
 
Description:  Investmend Account is a subclass of Savings Account with a 3% of 
Interest Rate, it cannot  be Overdrafted. In each deposit will be added a 
50% of the ammount deposited.
 */
public class InvestAccount extends SavingsAccount {

    /**
     * Default empty Constructor
     */
    public InvestAccount() {
    }

    /**
     * Constructor with Number, Balance and Customer Name arguments
     * @param accountNumber Account number identification
     * @param accountBalance Initial Balance of Account
     * @param customerName Customer Name
     */
    public InvestAccount(String accountNumber, double accountBalance, String customerName) {
        super(accountNumber, accountBalance, customerName);
        this.interestRate = 3;

    }

    /**
     * accountDeposit Overrides accountDeposit in Account Superclass, as the
     * method adds 50% over the amount deposited
     *
     * @param amount receives the amount to be calculated and assigned to
     * Balance
     */
    @Override
    public void accountDeposit(double amount) {
        double indexedDeposit = amount + (amount / 2);
        depositAmount = indexedDeposit;
        annualEarnings();
        calculateBalance(indexedDeposit);

    }

}
