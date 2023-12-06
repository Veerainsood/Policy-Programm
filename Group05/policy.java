import java.util.*;
//checks for parse int execption
class parseInteger extends Exception
{
    static int i=0;
    public static int parseInt(String s)
    {
        try
        {
            i=Integer.parseInt(s);
        }
        catch(Exception e){
            System.out.println("Invalid input. Please enter an integer.");
            return -1;
        }
        return i;
    }
}
class PolicyUtil {
    static Scanner sc = new Scanner(System.in);
//             try {
//                 String s = sc.nextLine();
//                 input = Integer.parseInt(s);
//             } catch (Exception e) {
//                 System.out.println("Invalid input. Please enter an integer.");
//                 sc.nextLine(); // Clear the input buffer
//             }
    // Helper method to get an integer input from the user.
    static int getIntInput() {
        int input = -1;
        while (input == -1) {
        String s = sc.nextLine();
        input=parseInteger.parseInt(s);
        }
        Util.sleep(80); // Sleep for 80 milliseconds
        return input;
    }

    // Helper method to clear the input buffer.
    static void clearInputBuffer() {
        sc.nextLine();
    }
}

abstract class Policy {
    static boolean AwardPolicy(Customer c) {
        return true;
    }

    static int[][] amount = { { 250000, 1000000 }, { 100000, 2500000 }, { 100000, 300000 } };

    public static boolean PolicyClaimEligibility(Customer c) {
        return true;
    }
}

class homeInsurance extends Policy {
    // the basic amount that will be given.
    static Scanner sc = new Scanner(System.in);
    public static boolean AwardPolicy(Customer c) {
        if (c.getStatus(0) == 2) {
            System.out.println("Sorry you have already taken our policy of this kind please choose other!! or you might be interested to upgrade to a better one!!\nContact our sales!! for more queries");
            return false;
        }
        if (c.getSalary() < 10000) {
            System.out.println(
                    "Your Salary is insufficient!!\nSorry, the policy cannot be given to you the minimum Salary for holding this policy is "
                            + 10000);
            c.setStatus(0, 1); // 1 for rejected
            return false;
        }
        System.out.println("Do you live in a rented place?\n1)Yes\n2)No");
        int terminate=1;
        while(terminate!=0)
        {
            try{
                int choice = PolicyUtil.getIntInput();
                Invalidchoice.takeinput(choice);
                if (choice == 1) {
                    System.out.println("Sorry, the policy cannot be given to you, as you live in rented place\nand our policy is eligible for only people who own their own home");
                c.setStatus(0, 1); // 1 for rejected
                terminate=0;
                 return false;
                }
                terminate=0;
            }
            catch(Exception e)
            {
                System.out.println("Please enter a valid choice ");
            }
            
        }
        
        System.out.println("Do you live in a disaster-prone area?\n1)Yes\n2)No");
        terminate=1;
        while(terminate!=0){
            try{
                int choice = PolicyUtil.getIntInput();
                Invalidchoice.takeinput(choice);
                if (choice == 1) {
                    c.setStatus(0, 1); // 1 for rejected
                System.out.println("Sorry, the policy cannot be given to you, as you live in a disaster-prone area");
                return false;
                }
                terminate=0;
            }
            catch(Exception e)
            {
                System.out.println("Please enter a valid choice ");
            }
        }
        System.out.println("Congrats!!!! You have successfully been granted your policy!!\n thank you for joining us!!");
        System.out.println("Starting from next month, an amount of Rs.8,000-/ will be deducted form your bank \n ");
        c.setStatus(0, 2); // 2 for given the policy
        return true;
        // 0 for not given 1 for rejected 2 for given the policy 3 for claim pending 4 for claim amount already granted
        // 0 for rejected/not approved 1 for pending
    }

    // user will come and ask for a policy claim with this function getting called for
    // the user.
    public static boolean PolicyClaimEligibility(Customer c) {
        int maxAmount = amount[0][c.getPremium(0)];
        if (c.getStatus(0) == 0) {
            System.out.println("You have not yet applied for any policy!!");
            return false;
        } else if (c.getStatus(0) == 1) {
            System.out.println(
                    "Your policy is rejected!! we are sorry your policy could not be granted!! please choose a granted policy");
            return false;
        } else if (c.getStatus(0) == 3) {
            System.out.println("Your policy claim is under review by our IA, please contact our office for further details");
            return true;
        } else if (c.getStatus(0) == 4) {
            System.out.println("your policy is active and you have already received the amount!!");
            return false;
        }
        // c.incidentDescription=new String();
        System.out.println("Write your reasons for claim (description):(1 line only)\n");
        c.Setincident(sc.nextLine(), 0);// pass int for policy number also
        int estimatedClaimAmount = 0;
        System.out.println("Enter your estimated claim amount:\n");
        estimatedClaimAmount = PolicyUtil.getIntInput();
        if (estimatedClaimAmount <= maxAmount) {
            System.out.println("You are eligible for your full amount claim!! Your policy is under review by our IA team!!\n"
                    + //
                    "Login As IA to Approve the Policy");
        } else {
            System.out.println("Sorry you are eligible for only: " + maxAmount
                    + " of grant from us as stated in your plan\nYour policy is under review by our IA team!!\n" + //
                    "Login As IA to Approve the Policy");

        }
        c.setStatus(0, 3);
        return true;
    }
}

class Lifeinsurance extends Policy {
    static Scanner sc = new Scanner(System.in);
    public static boolean AwardPolicy(Customer c) {
        if (c.getStatus(1) == 2) {
            System.out.println(
                    "Sorry you have already taken our policy of this kind please choose other!! or you might be interested to upgrade to a better one!!\nContact our sales!! for more queries");
            return false;
        }
        if (c.getSalary() < 10000) {
            System.out.println(
                    "Your Salary is insufficient!!\nSorry, the policy cannot be given to you the minimum Salary for holding this policy is "
                            + 10000);
            c.setStatus(1, 1);
            return false;
        }
        System.out.println("Do you smoke?\n1)YES\n2)no");
        int choice = PolicyUtil.getIntInput();
        if (choice == 1) {
            c.setStatus(1, 1);
            System.out.println("Sorry, the policy cannot be given to you, as you smoke!!");
            return false;
        } else {
            System.out.println("Do you Drink?\n1)Yes\n2)No");
            choice = PolicyUtil.getIntInput();
            if (choice == 1) {
                System.out.println("Sorry, the policy cannot be given to you, as you drink!!");
                c.setStatus(1, 1);
                return false;
            }
            System.out.println("Do you have Cancer of any type?\n1)Yes\n2)No");
            choice = PolicyUtil.getIntInput();
            if (choice == 1) {
                c.setStatus(1, 1);
                System.out.println("Sorry, the policy cannot be given to you, as you have cancer!!");
                return false;
            }
            System.out.println("Do you have AIDS?\n1)Yes\n2)No");
            choice = PolicyUtil.getIntInput();
            if (choice == 1) {
                c.setStatus(1, 1);
                System.out.println("Sorry, the policy cannot be given to you, as you have AIDS!!");
                return false;
            }
        }
        System.out.println("Congrats!!!! You have successfully been granted your policy!!\n Thank you for joining us!!");
        System.out.println("Starting from next month, an amount of Rs.8,000-/ will be deducted form your bank \n ");
        c.setStatus(1, 2);
        return true;
    }

    public static boolean PolicyClaimEligibility(Customer c) {
        int maxAmount = amount[1][c.getPremium(1)];
        if (c.getStatus(1) == 0) {
            System.out.println("You have not yet applied for any policy!!");
            return false;
        } else if (c.getStatus(1) == 1) {
            System.out.println(
                    "Your policy is rejected!! we are sorry your policy could not be granted!! please choose a granted policy");
            return false;
        } else if (c.getStatus(1) == 3) {
            System.out.println("Your policy claim is under review by our IA, please contact our office for further details");
            return true;
        } else if (c.getStatus(1) == 4) {
            System.out.println("your policy is active and you have already received the amount!!");
            return false;
        }
        System.out.println("Write your reasons for claim (description):(1 line only)\n");
        c.Setincident(sc.nextLine(), 1);// pass int for policy number also
        int estimatedClaimAmount = 0;
        System.out.println("Enter your estimated claim amount:\n");
        estimatedClaimAmount = PolicyUtil.getIntInput();
        if (estimatedClaimAmount <= maxAmount) {
            System.out.println("You are eligible for your full amount claim!! Your policy is under review by our IA team!!\n"
                    + //
                    "Login As IA to Approve the Policy");
        } else {
            System.out.println("Sorry you are eligible for only: " + maxAmount
                    + " of grant from us as stated in your plan\nYour policy is under review by our IA team!!\n" + //
                    "Login As IA to Approve the Policy");
        }
        c.setStatus(1, 3);
        return true;
    }
}

class automobileInsurance extends Policy {
    static Scanner sc = new Scanner(System.in);
    public static boolean AwardPolicy(Customer c) {
        if (c.getSalary() < 10000) {
            System.out.println(
                    """
                Your Salary is insufficient!!
                Sorry, the policy cannot be given to you
                The minimum Salary for holding this policy is 10000""");
            c.setStatus(2, 1);
            return false;
        }
        System.out.println("Do you have Pollution check certificate?\n1)YES\n2)no");
        int choice = PolicyUtil.getIntInput();
        if (choice == 2) {
            System.out.println("We are sorry, we can't design you the policy !!");
            c.setStatus(2, 1);
            return false;
        } else {
            System.out.println("Do you have Legal Automobile License certificate as well as driving license?\n1)Yes\n2)No");
            choice = PolicyUtil.getIntInput();
            if (choice == 2) {
                System.out.println("We are sorry, we can't design you the policy !!");
                c.setStatus(2, 1);
                return false;
            }
        }
        System.out.println("Congrats!!! We have designed the policy for your vehicle !!! thank you for joining us");
        System.out.println("Starting from next month, an amount of Rs.8,000-/ will be deducted form your bank \n ");
        c.setStatus(2, 2);
        return true;
    }

    public static boolean PolicyClaimEligibility(Customer c) {
        int maxAmount = amount[2][c.getPremium(2)];
        if (c.getStatus(2) == 0) {
            System.out.println("You have not yet applied for any policy!!");
            return false;
        } else if (c.getStatus(2) == 1) {
            System.out.println(
                    "Your policy is rejected!! we are sorry your policy could not be granted!! please choose a granted policy");
            return false;
        } else if (c.getStatus(2) == 3) {
            System.out.println("Your policy claim is under review by our IA, please contact our office for further details");
            return true;
        } else if (c.getStatus(2) == 4) {
            System.out.println("your policy is active and you have already received the amount!!");
            return false;
        }
        // c.incidentDescription=new String();
        System.out.println("Write your reasons for claim (description):(1 line only)\n");
        c.Setincident(sc.nextLine(), 2);// pass int for policy number also
        int estimatedClaimAmount = 0;
        System.out.println("Enter your estimated claim amount:\n");
        estimatedClaimAmount = PolicyUtil.getIntInput();
        if (estimatedClaimAmount <= maxAmount) {
            System.out.println("You are eligible for your full amount claim!! Your policy is under review by our IA team!!\n"
                    + //
                    "Login As IA to Approve the Policy");
        } else {
            System.out.println("Sorry you are eligible for only: " + maxAmount
                    + " of grant from us as stated in your plan\nYour policy is under review by our IA team!!\n" + //
                    "Login As IA to Approve the Policy");
        }
        c.setStatus(2, 3);
        return true;
    }
}