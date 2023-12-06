public class InvalidUserExeption extends Exception
{
    int index_of_exeption=0;
    InvalidUserExeption(String messageString)
    {
        super(messageString);
    }
}