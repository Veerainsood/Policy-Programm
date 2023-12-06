import java.util.Scanner;

public class Agent{
    static Scanner sc = new Scanner(System.in);

    public static void Policy(Customer c) throws InvalidInputExeption {
        System.out.println("0: To Get a Life Insurance ");
        Util.sleep(30);
        System.out.println("1: To Get a Home Insurance ");
        Util.sleep(30);
        System.out.println("2: To Get a Car Insurance ");//name it
        Util.sleep(30);
        System.out.println("3: To Go back ");
        int n = sc.nextInt();
        switch (n) {
            case 0:
                Lifeinsurance.AwardPolicy(c);
                break;
            case 1:
                homeInsurance.AwardPolicy(c);
                break;
            case 2:
                automobileInsurance.AwardPolicy(c);
                break;
            case 3:
                
                break;
            default:
                throw new InvalidInputExeption("Invalid input Exception");
        }
    }

    public static void createPolicy(Customer c) {
        System.out.println("0: To Get claim for Life Insurance ");
        Util.sleep(30);
        System.out.println("1: To Get claim for Home Insurance ");
        Util.sleep(30);
        System.out.println("2: To Get claim for Car Insurance ");//name it
        Util.sleep(30);
        System.out.println("3: To Go back ");
        int n = sc.nextInt();
        boolean f = false;
        c.resetVal(n);
        switch (n) {
            case 0:
                f = Lifeinsurance.PolicyClaimEligibility(c);
                break;
            case 1:
                f = homeInsurance.PolicyClaimEligibility(c);
                break;
            case 2:
                f = automobileInsurance.PolicyClaimEligibility(c);
                break;
            case 3:
                return ;
        }
            //yaha par ek exception bana sakte hai
    }
    public static void ViewCustomer(Customer c) {
        int width1 = 20;
        int width2 = 12;

        String s = "UserId";
        System.out.print(s);
        for(int i = 0;i<width2-s.length();i++){
            System.out.print(" ");
        }
//        System.out.println();
        s = "Name";
        System.out.print(s);
        for(int i = 0;i<(width2-s.length());i++){
            System.out.print(" ");
        }
//        System.out.println();

            s = "Home Insurance";
            System.out.print(s);
            for(int i = 0;i<width1-s.length();i++){
                System.out.print(" ");
            }
//            System.out.println();
//            System.out.println();
            s = "Life Insurance";
            System.out.print(s);
            for(int i = 0;i<width1-s.length();i++){
                System.out.print(" ");
            }
//            System.out.println();
//            System.out.println();
            s = "Car Insurance";
            System.out.print(s);
            for(int i = 0;i<width1-s.length();i++){
                System.out.print(" ");
            }
            System.out.println();

            Util.sleep(70);
            s = c.getUserId();
            System.out.print(s);
            for(int i = 0;i<width2-s.length();i++){
                System.out.print(" ");
            }
//            System.out.println();
            s = c.getName();
            System.out.print(s);
            for(int i = 0;i<(width2-s.length());i++){
                System.out.print(" ");
            }
//            System.out.println();
            s = Util.arr[c.getStatus(0)];
            System.out.print(s);
            for(int i = 0;i<width1-s.length();i++) {
                System.out.print(" ");
            }
//            System.out.println();
//            System.out.println();
            s = Util.arr[c.getStatus(1)];
            System.out.print(s);
            for(int i = 0;i<width1-s.length();i++){
                System.out.print(" ");
            }
//            System.out.println();
//            System.out.println();
            s = Util.arr[c.getStatus(2)];
            System.out.print(s);
            for(int i = 0;i<width1-s.length();i++){
                System.out.print(" ");
            }
//            System.out.println();

    }


    public static void upgrade(Customer c,int policyNumber)
    {
        if(c.getStatus(policyNumber)==0)
        {
            System.out.println("You haven't created a policy yet ");
            return;
        }
        if(c.getPremium(policyNumber)==0)
        {
            System.out.println("You will be charged extra ₹8000 per month for premium:\n1)Agree\n2)Disagree");
            int choice=sc.nextInt();
            if(choice==1)
            {
                System.out.println("Your policy has been upgraded !!");
                c.setPremium(1,policyNumber);
            }
            else
            {
                System.out.println("Your policy failed to be upgraded");
            }
        }
        else
        {
            System.out.println("Your policy is already upgraded to premium");
        }
        return;
    }

    public static void PremiumPayment(Customer c) {
        System.out.println("0: To Pay Premium for Home Insurance");
        Util.sleep(30);
        System.out.println("1: To Pay Premium for Life Insurance ");
        Util.sleep(30);
        System.out.println("2: To Pay Premium for Car Insurance ");//name it
        Util.sleep(30);
        System.out.println("3: To Go back ");
        int n = sc.nextInt();
            switch (n) {
                case 0:
                {
                    upgrade(c, 0);
                    break;
                }
                case 1:
                {
                    upgrade(c, 1);
                    break;
                }

                case 2:
                {
                    upgrade(c, 2);
                    break;
                }
                default:
                    try{
                    throw new InvalidInputExeption("Invalid Input!!");
                    }catch (InvalidInputExeption e){

                    }
            }
        //yaha par ek exeption bana sakte hai
    
        
    }
}