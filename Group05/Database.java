import java.util.*;

public class Database{
    static ArrayList<Customer> customers = new ArrayList<>();
    
    public static int CustomerIndex(String userId){
        int i=0;
        for(Customer c:customers){
            if(c.getUserId().equals(userId)){
                return i;
            }
            i++;
        }
        return -1;
    }
    public static int CheckPassword(int index, String Password){
        if(customers.get(index).getPassword().equals(Password)){
            return 1;
        }
        return 0;
    }


}