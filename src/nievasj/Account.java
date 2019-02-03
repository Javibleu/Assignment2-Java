/*
Class name: Account.java  
Name:       Javier Nievas
Date:       2-Feb-2019
 
Description:  Description about the class 
 */
package nievasj;

/**
 *
 * @author Javier Nievas
 */
public abstract class Account {

    protected String accountNumber;
    protected double accountBalance;
    protected String customerName;
    
    protected double depositAmount;
    protected double withdrawAmount;
    protected double interestRate;
    protected double amountEarned;

    /**
     * Empty Constructor
     */
    public Account() {
    }

    /**
     * Constructor with 3 arguments
     *
     * @param accountNumber Account number identification
     * @param accountBalance Initial Balance of Account
     * @param customerName Customer Name
     */
    public Account(String accountNumber, double accountBalance,
            String customerName) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.customerName = customerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Withdraw method
     * @param amount
     */
    public abstract void AccountWithdraw(double amount);

    /**
     *
     * @param deposit
     */
    public void AccountDeposit(double deposit) {
        depositAmount = deposit;
        AnnualEarnings();
        this.accountBalance += deposit;
        CalculateBalance();

    }

    /**
     * Calculate Annual Earnings
     *
     */
    public void AnnualEarnings() {
    amountEarned = accountBalance * interestRate / 100;

    }

    /**
     * Calculates the balance (Balance + Amount Earned with interest)
     *
     * 
     */
    public void CalculateBalance() {
        accountBalance+= amountEarned;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return String.format("%s %9.2f %9.2f %9.2f %9.2f", this.accountNumber, this.depositAmount,
                this.withdrawAmount, this.amountEarned, this.getAccountBalance());

    }

}
