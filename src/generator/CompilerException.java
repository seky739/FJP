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


    public CompilerException(String message){
        super(message);
    }
}
