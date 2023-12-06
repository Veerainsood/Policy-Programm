public class InvalidUserNameExeption extends Exception
{
    
    InvalidUserNameExeption()
    {
        System.out.println("Invalid UserName!!");
    }
    public void checkException(String name) throws InvalidUserNameExeption 
    {
        
        for(int i=0;i<name.length();i++)
            {
                if((int)name.charAt(i)<65)
                {
                    throw new InvalidUserNameExeption();
                } 
            }
    }

}