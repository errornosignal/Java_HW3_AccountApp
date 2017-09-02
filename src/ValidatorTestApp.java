/**
 * Created by errornosignal on 3/3/2017.
 * ValidatorTestApp class [PROG 1403]
 * Class for testing methods in Validator class
 * @author Reid Nolan
 * @since 03/02/2017
 * @version 1.0
 */
public class ValidatorTestApp
{
    //construct new instance of class object
    private Validator validator = new Validator();

    /**
     * runs instance of getInt from Validator
     * @return validator.userIntWithinRange
     */
    public int getIntTest()
    {
        //method call and value return
        validator.getInt();
        return validator.userIntWithinRange;
    }

    /**
     * runs instance of getInt from Validator
     * @return validator.userDoubleWithinRange
     */
    public double getDoubleTest()
    {
        //method call and value return
        validator.getDouble();
        return validator.userDoubleWithinRange;
    }

    /**
     * runs instance of getRequiredString from Validator
     * @return validator.validatedRequiredString
     */
    public String getRequiredStringTest()
    {
        //method call and value return
        validator.getRequiredString();
        return validator.validatedRequiredString;
    }

    /**
     * runs instance of getChoiceString from Validator
     * @return validator.validatedChoiceString
     */
    public String getChoiceStringTest()
    {
        //method call and value return
        validator.getChoiceString();
        return validator.validatedChoiceString;
    }
}