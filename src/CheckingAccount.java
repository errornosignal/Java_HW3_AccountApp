import java.math.BigDecimal;

/**
 * Created by errornosignal on 3/3/2017.
 * CheckingAccount class [PROG 1403]
 * Class for performing checking account calculations
 * @author Reid Nolan
 * @since 03/02/2017
 * @version 1.0
 */
public class CheckingAccount
{
    //declaration and initialization of local variables
    private static final BigDecimal monthlyFee = new BigDecimal(1.00);

    /**
     * updates account balance to reflect checking withdrawal transaction
     */
    public void withdrawalChecking()
    {
        //set variable and comparison to ensure availability of funds
        int checkingRes = AccountApp.amount.compareTo(AccountApp.checkingBalance.subtract(monthlyFee));

        if(checkingRes == 0 || checkingRes == -1)
        {
            //if funds are available process transaction
            AccountApp.checkingBalance = AccountApp.checkingBalance.subtract(AccountApp.amount.add(monthlyFee));
        }
        else
        {
            //if funds are not available display error and halt
            System.out.println("Insufficient funds! Enter another amount");
        }
    }

    /**
     * updates account balance to reflect checking deposit transaction
     */
    public void depositChecking()
    {
        AccountApp.checkingBalance = AccountApp.checkingBalance.add(AccountApp.amount.subtract(monthlyFee));
    }

    /**
     * gets checking monthly fee value
     * @return monthlyFee
     */
    public static BigDecimal getMonthlyFee()
    {
        return monthlyFee;
    }
}