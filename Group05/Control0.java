import java.util.Scanner;

public class Control0 {

    static Scanner sc = new Scanner(System.in);

    public static void CreateCustomer() {
        System.out.println("Enter The Following Information");
        Util.sleep(80);
        System.out.print("Enter your Name: ");
        String name = sc.nextLine();
        Util.sleep(80);
        System.out.print("Enter your Phone Number (10 Digits): ");

        String phoneNumber = "";
        long phNum = 0L;
        while (String.valueOf(phNum).length() != 10) {
            
            phoneNumber = sc.nextLine();
            //Exception checker for valid phone number 
            try {
                phNum = Long.parseLong(phoneNumber);
            }catch(Exception e){
                System.out.println("Invalid phone number. Please enter a 10-digit number.");
                System.out.println("Enter 0 to go back");
            }
            try{
                InvalidPhNumExeption.checkPhoneNumber(phNum); 
            }catch(InvalidPhNumExeption e){
            }
            if(phNum==0L){
                return;
            }
            
        }
        
        System.out.print("Enter your Address: ");
        String address = sc.nextLine();
        Util.sleep(80);

        System.out.print("Enter your Salary (If <10000 policy Cannot be Given): ");

        int salary = 0;
        //Added NumberFormatException handler...
        try {
            salary = Integer.parseInt(sc.nextLine());
            Util.sleep(80);
            if (salary < 10000) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("You will not be eligible to take any policy for salary < 10000.");
            return;
        }

        int u = (int) (Math.random() * (9999 - 1000 + 1) + 1000);
        String userId = "U" + u;
        System.out.println("Your User Id is: " + userId);
        int pin = (int) (Math.random() * (99999 - 10000 + 1) + 10000);
        System.out.println("A random pin is generated for this");
        Util.sleep(90);
        System.out.println("Your New Pin is: " + pin);
        Util.sleep(90);
        System.out.println("Remember Your pin for further Login");
        System.out.print("Enter 0 to change pin else 1: ");
        String s;

        if (Util.getIntInput() == 0) {
            int p = 0;
            System.out.print("Enter Your New Desired Pin: ");

            s = sc.nextLine();
            while (true) {
                if (s.length() == 1) {
                    if (s.charAt(0) == '0') {
                        p = pin;
                        break;
                    }
                }
                //invalid pin exeption handeling
                try {
                    if (s.length() == 5) {
                        p = Integer.parseInt(s);
                        System.out.println("Please Remember Your pin for further withdraw");
                    }
                } catch (Exception e) {
                    System.out.println("Not all are Digits. Try again.");
                }

                if (p != 0) {

                    break;
                }

                if (s.length() != 5)
                    System.out.println("Entered length was not 5 digits");
                Util.sleep(90);
                System.out.println("Enter 0 to go back");
                Util.sleep(90);
                System.out.print("Enter the Pin (5 digits): ");
                s = sc.nextLine();
            }
            pin = p;
        }

        String password = String.valueOf(pin);
        Customer c = new Customer(name, address, phoneNumber, userId, password, salary);
        Database.customers.add(c);
        System.out.println("Please Login As customer to Get Policy with Following Details");
        System.out.println("User Id : " + userId);
        System.out.println("Pin : " + pin);
    }

    public static void Interface() {
        System.out.print("Enter your userid: ");
        String userId = sc.nextLine();
        System.out.print("Enter your PIN: ");
        String enteredPin = sc.nextLine();
        while (CusInterface(userId, enteredPin) == 1);
    }

    public static int CusInterface(String userId, String enteredPin) {
        System.out.println("\n\n");
        int k = Database.CustomerIndex(userId);
        //Invalid user exception implemented 
        try{
            if(k==-1)
                throw new InvalidUserExeption("No such User With User Id : " + userId);
        }catch(InvalidUserExeption e){
            return 0;
        }
        
        if (Database.CheckPassword(k, enteredPin) == 0) {
            System.out.println("Wrong Password!!");
            return 0;
        }
        Customer c = Database.customers.get(k);
        System.out.println("Enter the Number for the following Task : ");
        Util.sleep(80);
        System.out.println("0: To get Details ");
        Util.sleep(80);
        System.out.println("1: To Get a Policy");
        Util.sleep(80);
        System.out.println("2: To Upgrade Your Premium ");
        Util.sleep(80);
        System.out.println("3: To claim insurance / view claim Status ");
        Util.sleep(80);
        System.out.println("4: To claim status record - approved, rejected, or pending ");
        Util.sleep(80);
        System.out.println("5: Go to Login Page");
        Util.sleep(80);
        System.out.print("Enter Your Choice : ");
        int n = Util.getIntInput();
        switch (n) {
            case 0:
                c.ViewDetails(1);
                break;
            case 1:
                try{//guys fix this
                    Agent.Policy(c);
                }catch(InvalidInputExeption ignore){}
                break;
            case 2:
                Agent.PremiumPayment(c);
                break;
            case 3:
                Agent.createPolicy(c);
                break;
            case 4:
                Agent.ViewCustomer(c);
                break;
            case 5:
                return 0;
        }
        return 1;
    }

    public static int iaInterface() {
        System.out.println("\n\n");
        System.out.println("Enter the Number for the following Task : ");
        Util.sleep(80);
        System.out.println("0: To View All Customers");
        Util.sleep(80);
        System.out.println("1: To View All Customer with Pending Home Insurance Claim");
        Util.sleep(80);
        System.out.println("2: To View All Customer with Pending Life Insurance Claim");
        Util.sleep(80);
        System.out.println("3: To View All Customer with Pending Car Insurance Claim");
        Util.sleep(80);
        System.out.println("4: To Approve The Claim of Any Customer");
//        Util.sleep(80);
//        System.out.println("5: To Approve The Policy");
        Util.sleep(80);
        System.out.println("9: Go to Login Page");
        Util.sleep(80);
        System.out.print("Enter Your Choice : ");
        int n = Util.getIntInput();
        switch (n) {
            case 0:
                ViewCustomer(-1);
                break;
            case 1:
                ViewCustomer(0);
                break;
            case 2:
                ViewCustomer(1);
                break;
            case 3:
                ViewCustomer(2);
                break;
            case 4:
                ApproveClaim();
                break;
            case 9:
                return 0;
        }
        return 1;
    }



    private static void ApproveClaim() {
        System.out.print("Enter the UserId to Be Approved : ");
        String userId = sc.nextLine();
        System.out.println("\n\n");
        int k = Database.CustomerIndex(userId);
        try{
                throw new InvalidUserExeption("No such User With User Id : " + userId);
        }catch(InvalidUserExeption e){}
        Database.customers.get(k).ViewDetails(0);
        System.out.println();
        System.out.println("Above Are the details of the customer");
        Util.sleep(80);
        System.out.println("0: To Go Back");
        Util.sleep(80);
        System.out.println("1: To Approve Pending Home Insurance Claim");
        Util.sleep(80);
        System.out.println("2: To Approve Pending Life Insurance Claim");
        Util.sleep(80);
        System.out.println("3: To Approve Pending Car Insurance Claim");
        int n = Util.getIntInput();
        switch (n) {
            case 0:
                return;
            case 1, 3, 2:
                // 0 for not given 1 for rejected 2 for given the policy 3 for claim pending 4 for claim amount already granted 5 for policy pending
                if (Database.customers.get(k).getStatus(n - 1) == 3) {
                    Database.customers.get(k).setStatus(n - 1, 4);
                    System.out.println("Claim Approved");
                } else {
                    System.out.println("Selected Claim is not Pending");
                }
                break;
        }
    }

    public static void ViewCustomer(int k) {
        int width1 = 20;
        int width2 = 12;
        StringBuilder bl = new StringBuilder("|");
        bl.append(" ".repeat(width1 + width2 - 1));
        bl.append("|");

        String s = "UserId";
        System.out.print(s);
        for (int i = 0; i < width2 - s.length(); i++) {
            System.out.print(" ");
        }
        s = "Name";
        System.out.print(s);
        for (int i = 0; i < (width2 - s.length()); i++) {
            System.out.print(" ");
        }
        if (k != -1) {
            s = Util.arr2[k];
            System.out.print(s);
            for (int i = 0; i < width1 - s.length(); i++) {
                System.out.print(" ");
            }
        } else {
            s = "Home Insurance";
            System.out.print(s);
            for (int i = 0; i < width1 - s.length(); i++) {
                System.out.print(" ");
            }
            s = "Life Insurance";
            System.out.print(s);
            for (int i = 0; i < width1 - s.length(); i++) {
                System.out.print(" ");
            }
            s = "Car Insurance";
            System.out.print(s);
            for (int i = 0; i < width1 - s.length(); i++) {
                System.out.print(" ");
            }
        }
        for (Customer c : Database.customers) {
            System.out.println();
            Util.sleep(100);
            if (k != -1) {
                if (c.getStatus(k) == 0) {
                    continue;
                }
            }
            s = c.getUserId();
            System.out.print(s);
            for (int i = 0; i < width2 - s.length(); i++) {
                System.out.print(" ");
            }
            s = c.getName();
            System.out.print(s);
            for (int i = 0; i < (width2 - s.length()); i++) {
                System.out.print(" ");
            }

            if (k != -1) {
                s = Util.arr[c.getStatus(k)];
                System.out.print(s);
                for (int i = 0; i < width1 - s.length(); i++) {
                    System.out.print(" ");
                }
                continue;
            }
            s = Util.arr[c.getStatus(0)];
            System.out.print(s);
            for (int i = 0; i < width1 - s.length(); i++) {
                System.out.print(" ");
            }
            s = Util.arr[c.getStatus(1)];
            System.out.print(s);
            for (int i = 0; i < width1 - s.length(); i++) {
                System.out.print(" ");
            }
            s = Util.arr[c.getStatus(2)];
            System.out.print(s);
            for (int i = 0; i < width1 - s.length(); i++) {
                System.out.print(" ");
            }
        }
    }
}
