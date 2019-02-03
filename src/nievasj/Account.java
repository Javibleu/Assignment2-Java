package nievasj;
/*
Class name: Account.java  
Name:       Javier Nievas
Date:       2-Feb-2019
 
Description:  Abstract class Account models the different types of accounts
The class implements the different methods shared whith the Subclasses 
as Chequing Account, Savings Account or Investment Account.
 */
public abstract class Account {

    protected String accountNumber; //Stores Account number
    protected double accountBalance;//Stores Account Balance
    protected String customerName;  //Stores Customer Name
    protected double depositAmount; //Stores Amount Deposited
    protected double withdrawAmount;//Stores Amount Witdrawed 
    protected double interestRate;  //Stores Interest Rate of Each Account type
    protected double amountEarned;  //Stores Amount Earned 

    /**
     * Default empty Constructor
     */
    public Account() {
    }

    /**
     * Constructor with Number, Balance and Customer Name arguments
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

    /**
     * Account Number Getter
     *
     * @return Account Number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Account number Setter
     *
     * @param accountNumber Account Number
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Account Balance Getter
     *
     * @return Balance in Account
     */
    public double getAccountBalance() {
        return accountBalance;
    }

    /**
     * Account Balance Setter
     *
     * @param accountBalance receive the amount to be assigned
     */
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * Customer Name Getter
     *
     * @return Customer Name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Customer Name Setter
     *
     * @param customerName receive the Name of Customer
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Withdraw Abstract method to be implemented in Subclasses
     *
     * @param amount to receive the amount to be withdrawn
     */
    public abstract void accountWithdraw(double amount);

    /**
     * Deposit method receive the amount to be deposited and call the methods to
     * calculate interest.
     *
     * @param amount to receive the amount to add to balance
     */
    public void accountDeposit(double amount) {
        depositAmount = amount;
        calculateBalance(amount);
    }

    /**
     * Calculates the balance (Balance + Amount Earned with interest)
     * @param amount receives the amount deposited to calculate the final
     * balance
     */
    public void calculateBalance(double amount) {
        accountBalance = accountBalance + annualEarnings() + amount;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * Calculate Annual Earnings based in deposit amount and interest rate
     *
     * @return amount Earned
     */
    public double annualEarnings() {
        amountEarned = accountBalance * interestRate / 100;
        return amountEarned;
    }

    @Override
    public String toString() {
        return String.format("%s %9.2f %9.2f %9.2f %9.2f", this.accountNumber, this.depositAmount,
                this.withdrawAmount, this.amountEarned, this.getAccountBalance());

    }

}
