package generator;

public class CompilerException extends Exception{
    public static final String ERR_UNDEFINED_VARIABLE = "Undefined variable";
    public static final String ERR_DUPLICATED_VARIABLE = "Duplicated variable";
    public static final String ERR_IMMUTABLE_CONSTANTS = "Constants are immutable";
    public static final String ERR_PARALLEL_COUNT = "Number of variables and values do not match";
    public static final String ERR_UNKNOWN = "Unknown error";
    public static final String ERR_WRONG_TYPE = "Wrong data type";
    public static final String ERR_DUPLICATED_CASES = "Duplicated cases in switch";
    public static final String ERR_WRONG_RETURN_TYPE = "Returned wrong type";
    public static final String ERR_UNDEFINED_METHOD = "Undefined method";
    public static final String ERR_DUPLICATE_METHOD = "Duplicated method";
    public static final String ERR_WRONG_PARAMETER_NUMBER = "Wrong parameter number";
    public static final String ERR_TOO_MANY_PARAMETERS = "Too many method parameters. Maximum parameter count is 3";
    public static final String ERR_NO_VALID_MAIN_METHOD = "No valid main method was found";
    public static final String ERR_MISSING_RETURN_VALUE = "Missing return variable";


    public CompilerException(String message){
        super(message);
    }
}
