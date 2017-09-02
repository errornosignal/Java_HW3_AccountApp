import java.util.*;

/**
 * Created by errornosignal on 3/3/2017.
 * Validator class [PROG 1403]
 * Class for validation of user input
 * @author Reid Nolan
 * @since 03/02/2017
 * @version 1.0
 */
public class Validator
{
    //create new scanner
    static Scanner sc = new Scanner(System.in);

    //declare class variables
    int userIntWithinRange = 0;
    double userDoubleWithinRange = 0.0;
    String validatedRequiredString = "";
    String validatedChoiceString = "";

    /**
     * gets integer value
     * @return userIntWithinRange
     */
    public int getInt()
    {
        //method header
        System.out.println("Int Test");

        //method call and value return
        getIntWithinRange();
        System.out.println();
        return this.userIntWithinRange;
    }

    /**
     * prompts for and validates integer input
     * @return userIntWithinRange
     */
    public int getIntWithinRange()
    {
        //declare and initialize loop condition
        boolean intValid = false;
        while (!intValid)
        {
            //declare and initialize local constant variables
            final int kINT_MIN = -100;
            final int kINT_MAX = 100;

            //prompt for input
            System.out.print("Enter and integer between " + kINT_MIN + " and " + kINT_MAX + ": ");

            //try/catch block to handle exception
            try
            {
                //set scanner input to new variable
                int userInt = sc.nextInt();

                //input validation
                if (userInt > kINT_MIN && userInt < kINT_MAX)
                {
                    //set loop condition to true
                    intValid = true;
                    //set input value to validated return value
                    this.userIntWithinRange = userInt;
                }
                else if (userInt < kINT_MIN)
                {
                    //display error for input out of range
                    System.out.println("Error! Number must be greater than " + (kINT_MIN - 1));
                }
                else if (userInt > kINT_MAX)
                {
                    //display error for input out of range
                    System.out.println("Error! Number must be less than " + (kINT_MAX + 1));
                }
                else
                {
                    //display error for non-integer input
                    System.out.println("Error! Invalid integer value. Try again.");
                }
            }
            catch (InputMismatchException IOE)
            {
                //display warning and clear input stream for non-integer input
                System.out.println("Error! Invalid integer value. Try again.");
                sc.reset();
                sc.next();
            }
        }
        //return value
        return this.userIntWithinRange;
    }

    /**
     * gets double value
     * @return userDoubleWithinRange
     */
    public double getDouble()
    {
        //method header
        System.out.println("Double Test");

        //method call and value return
        getDoubleWithinRange();
        System.out.println();
        return this.userDoubleWithinRange;
    }

    /**
     * prompts for and validates double input
     * @return userDoubleWithinRange
     */
    public double getDoubleWithinRange()
    {
        //declare and initialize loop condition
        boolean doubleValid = false;
        while (!doubleValid)
        {
            //declare and initialize local constant variables
            final double kDOUBLE_MIN = -100.0;
            final double kDOUBLE_MAX = 100.0;

            //prompt for input
            System.out.print("Enter any number between " + kDOUBLE_MIN + " and " + kDOUBLE_MAX + ": ");

            //try/catch block to handle exception
            try
            {
                //set scanner input to new variable
                double userDouble = sc.nextDouble();

                //input validation
                if (userDouble > kDOUBLE_MIN && userDouble < kDOUBLE_MAX)
                {
                    //set input value to validated return value
                    this.userDoubleWithinRange = userDouble;
                    //set loop condition to true
                    doubleValid = true;
                }
                else if (userDouble < kDOUBLE_MIN)
                {
                    //display error for input out of range
                    System.out.println("Error! Number must be greater than " + (kDOUBLE_MIN));
                }
                else if (userDouble > kDOUBLE_MAX)
                {
                    //display error for input out of range
                    System.out.println("Error! Number must be less than " + (kDOUBLE_MAX));
                }
                else
                {
                    //display error for non-double input
                    System.out.println("Error! Invalid decimal value. Try again.");
                }
            }
            catch (InputMismatchException IOE)
            {
                //display warning and clear input stream
                System.out.println("Error! Invalid decimal value. Try again.");
                sc.reset();
                sc.next();
            }
        }
        //return value
        return this.userDoubleWithinRange;
    }

    /**
     * prompts for and validates first string input
     * @return validatedRequiredString
     */
    public String getRequiredString()
    {
        //clear EOL token from previous scanner use
        sc.nextLine();

        //method header
        System.out.println("Required String Test");

        //declare and initialize loop condition
        boolean reqStringValid = false;
        while (!reqStringValid)
        {
            //prompt for input
            System.out.print("Enter your email address: ");

            //set scanner input to new variable
            String userRequiredString = sc.nextLine();

            //input validation
            if (userRequiredString.isEmpty())
            {
                //display warning and clear input stream for empty input
                System.out.println("Error! This entry is required. Try again.");
            }
            else
            {
                //set input value to validated return value
                this.validatedRequiredString = userRequiredString;
                //set loop condition to true
                reqStringValid = true;
            }
        }
        System.out.println();
        //return value
        return this.validatedRequiredString;
    }

    /**
     * prompts for and validates second string input
     * @return validatedChoiceString
     */
    public String getChoiceString()
    {
        //method header
        System.out.println("Choice String Test");

        //declare and initialize loop condition
        boolean choiceStringValid = false;
        while (!choiceStringValid)
        {
            //prompt for input
            System.out.print("Select one (x/y): ");

            //set scanner input to new variable
            String userChoiceString = sc.nextLine();

            //try/catch block
            try
            {
                //get first char from input
                userChoiceString = String.valueOf(userChoiceString.charAt(0));

                //input validation
                switch (userChoiceString)
                {
                    case "x":
                        //set input value to validated return value
                        this.validatedChoiceString = userChoiceString;
                        //set loop condition to true
                        choiceStringValid = true;
                        break;
                    case "y":
                        //set input value to validated return value
                        this.validatedChoiceString = userChoiceString;
                        //set loop condition to true
                        choiceStringValid = true;
                        break;
                    default:
                        //display error on invalid input
                        System.out.println("Error! Entry must be 'x' or 'y'. Try again.");
                }
            }
            catch(Exception e)
            {
                //display warning and clear input stream for empty input
                System.out.println("Error! This entry is required. Try again.");
                sc.reset();
            }
        }
        System.out.println();
        //return value
        return this.validatedChoiceString;
    }
}