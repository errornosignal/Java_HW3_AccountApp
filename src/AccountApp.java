import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * Created by errornosignal on 3/3/2017.
 * AccountApp class [PROG 1403]
 * Class for running accounting application
 * @author Reid Nolan
 * @since 03/02/2017
 * @version 1.0
 */
public class AccountApp
{
    //declaration of local variables
    private String validatedTransString = "";
    private String validatedCsString = "";
    private String validatedContString = "";
    static BigDecimal amount = BigDecimal.ZERO;
    static BigDecimal checkingBalance = new BigDecimal(1000.00);
    static BigDecimal savingsBalance = new BigDecimal(1000.00);

    //set new format instance
    private final NumberFormat currency = NumberFormat.getCurrencyInstance();

    /**
     * displays balance information
     */
    public void displayBalance()
    {
        //reset scanner
        Validator.sc.reset();
        //display balance info
        System.out.println("Starting Balances");
        System.out.println("Checking: " + currency.format(checkingBalance));
        System.out.println("Savings: " + currency.format(savingsBalance));
        System.out.println();
    }

    /**
     * displays prompt for monthly transaction entry
     */
    public void enterTransactions()
    {
        System.out.println("Enter the transactions for the month:");
        System.out.println();
        Validator.sc.nextLine();
    }

    /**
     * prompts for, validates, and returns menu selection
     * @return this.validatedTransString
     */
    public String transactionType()
    {
        //declare and initialize loop condition
        boolean transStringValid = false;
        while (!transStringValid)
        {
            //prompt for input
            System.out.print("Withdrawal or deposit? (w/d): ");

            //set scanner input to new variable
            String transMenu = Validator.sc.nextLine();

            //try/catch block
            try
            {
                //get first char from input
                transMenu = String.valueOf(transMenu.charAt(0));

                //input validation
                switch (transMenu)
                {
                    case "w":
                        //set input value to validated return value
                        this.validatedTransString = transMenu;
                        //set loop condition to true
                        transStringValid = true;
                        break;
                    case "d":
                        //set input value to validated return value
                        this.validatedTransString = transMenu;
                        //set loop condition to true
                        transStringValid = true;
                        break;
                    default:
                        //display error on invalid input
                        System.out.println("Error! Entry must be 'w' or 'd'. Try again.");
                }
            } catch (Exception e)
            {
                //display warning and clear input stream for empty input
                System.out.println("Error! This entry is required. Try again.");
                Validator.sc.reset();
            }
        }
        //return value
        return this.validatedTransString;
    }

    /**
     * prompts for, validates, and returns menu selection
     * @return this.validatedCsString
     */
    public String checkingOrSavings()
    {
        //declare and initialize loop condition
        boolean csStringValid = false;
        while (!csStringValid)
        {
            //prompt for input
            System.out.print("Checking of Savings? (c/s): ");

            //set scanner input to new variable
            String csMenu = Validator.sc.nextLine();

            //try/catch block
            try
            {
                //get first char from input
                csMenu = String.valueOf(csMenu.charAt(0));

                //input validation
                switch (csMenu)
                {
                    case "c":
                        //set input value to validated return value
                        this.validatedCsString = csMenu;
                        //set loop condition to true
                        csStringValid = true;
                        break;
                    case "s":
                        //set input value to validated return value
                        this.validatedCsString = csMenu;
                        //set loop condition to true
                        csStringValid = true;
                        break;
                    default:
                        //display error on invalid input
                        System.out.println("Error! Entry must be 'c' or 's'. Try again.");
                }
            }
            catch (Exception e)
            {
                //display warning and clear input stream for empty input
                System.out.println("Error! This entry is required. Try again.");
                Validator.sc.reset();
            }
        }
        //return value
        return this.validatedCsString;
    }

    /**
     * prompts for, validates, and returns menu selection
     * @return amount
     */
    public BigDecimal getAmount()
    {
        //prompt for input
        System.out.print("Amount?: ");
        //set variable to next scanner input
        amount = Validator.sc.nextBigDecimal();
        System.out.println();
        //return value
        return amount;
    }

    /**
     *
     * @return
     */
    public String cOntinue()
    {
        //clear EOL token from previous scanner use
        Validator.sc.nextLine();

        ////declare and initialize loop condition
        boolean contStringValid = false;
        while (!contStringValid)
        {
            //prompt for input
            System.out.print("Continue? (y/n):");
            //set variable to next scanner input
            String contMenu = Validator.sc.nextLine();
            System.out.println();

            //try/catch block
            try
            {
                //get first char from input
                contMenu = String.valueOf(contMenu.charAt(0));

                //input validation
                switch (contMenu)
                {
                    case "y":
                        //set input value to validated return value
                        this.validatedContString = contMenu;
                        //set loop condition to true
                        contStringValid = true;
                        break;
                    case "n":
                        //set input value to validated return value
                        this.validatedContString = contMenu;
                        //set loop condition to true
                        contStringValid = true;
                        break;
                    default:
                        //display error on invalid input
                        System.out.println("Error! Entry must be 'y' or 'n'. Try again.");
                }
            }
            catch (Exception e)
            {
                //display warning and clear input stream for empty input
                System.out.println("Error! This entry is required. Try again.");
                Validator.sc.reset();
            }
        }
        //return value
        return this.validatedContString;
    }

    /**
     * displays monthly payments and fees totals
     */
    public void monthlyPaymentsFees()
    {
        System.out.println("Monthly Payments and Fees");
        System.out.println("Checking Fee: " + currency.format(CheckingAccount.getMonthlyFee()));
        System.out.println("Savings interest payment: " + currency.format(SavingsAccount.getSavingsInterest()));
        System.out.println();
    }

    /**
     * displays final account balances
     */
    public void showFinalBalances()
    {
        System.out.println("Final Balances");
        System.out.println("Checking: " + currency.format(checkingBalance));
        System.out.println("Savings: " + currency.format(savingsBalance.add(savingsBalance.multiply(BigDecimal.valueOf(SavingsAccount.savingsInterest)))));
        System.out.println();
    }
}