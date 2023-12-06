public class Invalidchoice extends Exception
{
    Invalidchoice(String message)
    {
        super(message);
    }
    public static void takeinput(int choice) throws Invalidchoice
    {
           if((choice!=1)&&(choice!=2))
            {
                throw new Invalidchoice("You chose an invalid choice!!");  
            }
        return; 
    }
}