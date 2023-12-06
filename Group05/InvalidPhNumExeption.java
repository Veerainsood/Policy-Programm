public class InvalidPhNumExeption extends Exception
{
    InvalidPhNumExeption(String exptnString)
    {
        super(exptnString);
    }
    
    public static void checkPhoneNumber(long phNum) throws InvalidPhNumExeption
    {
        if(String.valueOf(phNum).length() != 10) {
        throw new InvalidPhNumExeption("Invalid phone number.");
        }
    }
}