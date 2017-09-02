import java.math.BigDecimal;

/**
 * Created by errornosignal on 3/3/2017.
 * SavingsAccount class [PROG 1403]
 * Class for performing savings account calculations
 * @author Reid Nolan
 * @since 03/02/2017
 * @version 1.0
 */
public class SavingsAccount
{
    //declaration and initialization of local variables
    static final double savingsInterest = 0.01;
    private static BigDecimal interestPayment = new BigDecimal(0.00);

    /**
     * updates account balance to reflect savings withdrawal transaction
     */
    public void withdrawalSavings()
    {
        //set variable and comparison to ensure availability of funds
        int savingsRes = AccountApp.amount.compareTo(AccountApp.savingsBalance);

        if(savingsRes == 0 || savingsRes == -1)
        {
            //if funds are available process transaction
            AccountApp.savingsBalance = AccountApp.savingsBalance.subtract(AccountApp.amount);
            AccountApp.savingsBalance = AccountApp.savingsBalance.add(interestPayment);
        }
        else
        {
            //if funds are not available display error and halt
            System.out.println("Insufficient funds! Enter another amount");
        }
    }

    /**
     * updates account balance to reflect savings deposit transaction
     */
    public void depositSavings()
    {
        AccountApp.savingsBalance = AccountApp.savingsBalance.add(AccountApp.amount);
        AccountApp.savingsBalance = AccountApp.savingsBalance.add(interestPayment);
    }

    /**
     * gets checking monthly fee value
     * @return AccountApp.savingsBalance.multiply(BigDecimal.valueOf(SavingsAccount.savingsInterest))
     */
    public static BigDecimal getSavingsInterest()
    {
        return AccountApp.savingsBalance.multiply(BigDecimal.valueOf(SavingsAccount.savingsInterest));
    }
}