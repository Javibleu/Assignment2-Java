/*
Class name: InvestAccount.java  
Name:       Javier Nievas
Date:       2-Feb-2019
 
Description:  Description about the class 
 */
package nievasj;

/**
 *
 * @author Javier Nievas
 */
public class InvestAccount extends SavingsAccount {

    public InvestAccount() {
    }

    public InvestAccount(String accountNumber, double accountBalance, String customerName) {
        super(accountNumber, accountBalance, customerName);
        this.interestRate = 3;

    }

    @Override
    public void AccountDeposit(double deposit) {
        double indexedDeposit = deposit + (deposit / 2);
        depositAmount = indexedDeposit;
        AnnualEarnings();
        this.accountBalance += indexedDeposit;
        CalculateBalance();

    }

}
