import java.util.*;

/**
 * Created by errornosignal on 3/3/2017.
 * HW3 Validator [PROG 1403]
 * Program for validating user input from the console, also includes an application for testing validation methods
 * @author Reid Nolan
 * @since 03/02/2017
 * @version 1.0
 */
public class Main
{
    /**
     * Main method
     */
    public static void main(String[] args)
    {
        //display program header
        System.out.println("Reid_Nolan_ HW3[Validator]");
        System.out.println();

        //loop indefinitely until user exit
        while (true)
        {
            //display main menu and input prompt
            System.out.println("Main Menu");
            System.out.println("1. Go to Part 1.");
            System.out.println("2. Go to Part 2.");
            System.out.println("3. Exit the program.");
            System.out.print("Enter a choice: ");

            //try/catch block
            try
            {
                //get input for menu selection
                int mainMenu = Validator.sc.nextInt();

                //main menu selection switch
                switch (mainMenu)
                {
                    //run part 1
                    case 1:
                        while (true)
                        {
                            //display part1 menu and input prompt
                            System.out.println();
                            System.out.println("Part 1 Menu");
                            System.out.println("1. Continue the program.");
                            System.out.println("2. Run the validation test application.");
                            System.out.println("3. Go back to the main menu.");
                            System.out.print("Enter a choice: ");

                            //try/catch block
                            try
                            {
                                //get input for menu selection
                                int part1Menu = Validator.sc.nextInt();

                                //switch for menu choice
                                switch (part1Menu)
                                {
                                    //run part 1 main program
                                    case 1:
                                    {
                                        //construct new instance of class object
                                        Validator validator = new Validator();

                                        System.out.println();

                                        //call methods of class
                                        validator.getInt();
                                        validator.getDouble();
                                        validator.getRequiredString();
                                        validator.getChoiceString();

                                        //display status message and return to main menu
                                        System.out.println("returning to the main menu...");
                                        System.out.println();
                                        break;
                                    }
                                    //run part 1 testApp
                                    case 2:
                                    {
                                        //construct new instance of class object
                                        ValidatorTestApp validatorTestApp = new ValidatorTestApp();

                                        System.out.println();

                                        //call methods of class and set to local variables
                                        int Int = validatorTestApp.getIntTest();
                                        double Double = validatorTestApp.getDoubleTest();
                                        String reqString = validatorTestApp.getRequiredStringTest();
                                        String choiceString = validatorTestApp.getChoiceStringTest();

                                        //display return values of methods
                                        System.out.println();
                                        System.out.println("Int: " + Int);
                                        System.out.println("Double: " + Double);
                                        System.out.println("ReqString: " + reqString);
                                        System.out.println("ChoiceString: " + choiceString);
                                        System.out.println("Data validation successful!");
                                        System.out.println("returning to the main menu...");
                                        System.out.println();
                                        break;
                                    }
                                    //go back to the main menu
                                    case 3:
                                    {
                                        //display status message and return to main menu
                                        System.out.println("returning to the main menu...");
                                        System.out.println();
                                        break;
                                    }
                                    default:
                                        break;
                                }
                                break;
                            }
                            catch (InputMismatchException IOE)
                            {
                                //display warning and clear input stream for non-integer input
                                System.out.println("Error! Invalid selection. Try again.");
                                Validator.sc.reset();
                                Validator.sc.next();
                            }
                        }
                        break;
                    //run part 2
                    case 2:
                    {
                        //pull from part 2
                        System.out.println();
                        //display section header
                        System.out.println("Part 2");

                        //construct new instance of class object
                        AccountApp accountApp = new AccountApp();
                        //call methods from class
                        accountApp.displayBalance();
                        accountApp.enterTransactions();

                        //declaration of menu option variables
                        String nextCont;
                        String nextTrans;
                        String nextAccount;

                        //do until user exits
                        do
                        {
                            //set methods returned values to menu option variables
                            nextTrans = accountApp.transactionType();
                            nextAccount = accountApp.checkingOrSavings();
                            //method call
                            accountApp.getAmount();
                            //method navigation statements for menu options
                            if(Objects.equals(nextTrans, "w"))
                            {
                                //withdrawal
                                if(Objects.equals(nextAccount, "c"))
                                {
                                    //withdrawal from checking
                                    CheckingAccount checkingAccount = new CheckingAccount();
                                    checkingAccount.withdrawalChecking();
                                }
                                else if(Objects.equals(nextAccount, "s"))
                                {
                                    //withdrawal from savings
                                    SavingsAccount savingsAccount = new SavingsAccount();
                                    savingsAccount.withdrawalSavings();
                                }
                            }
                            else if(Objects.equals(nextTrans, "d"))
                            {
                                //deposit
                                if(Objects.equals(nextAccount, "c"))
                                {
                                    //deposit to checking
                                    CheckingAccount checkingAccount = new CheckingAccount();
                                    checkingAccount.depositChecking();
                                }
                                else if(Objects.equals(nextAccount, "s"))
                                {
                                    //deposit to savings
                                    SavingsAccount savingsAccount = new SavingsAccount();
                                    savingsAccount.depositSavings();
                                }
                            }
                            //method to get continue or exit
                            nextCont = accountApp.cOntinue();
                        }while(Objects.equals(nextCont, "y"));

                        //display final balance info output
                        accountApp.monthlyPaymentsFees();
                        accountApp.showFinalBalances();
                        //display status message before breaking back to main menu
                        System.out.println("returning to the main menu...");
                        System.out.println();
                        break;
                    }
                    //exit program
                    case 3:
                    {
                        //display message and terminate program
                        System.out.println("exiting program...");
                        System.exit(1);
                    }
                }
            }
            catch (InputMismatchException IOE)
            {
                //display warning and clear input stream for non-integer input
                System.out.println("Error! Invalid selection. Try again.");
                System.out.println();
                Validator.sc.reset();
                Validator.sc.next();
            }
        }
    }
}