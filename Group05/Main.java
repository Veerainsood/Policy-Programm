import java.util.*;

public class Main {

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int pin = (int) (Math.random() * (99999 - 10000 + 1) + 10000);

        while (true) {
            System.out.println("\n\n");
            System.out.println("Enter the Number for the following Task : ");

            Util.sleep(30);
            System.out.println("1: To Login as Customer");
            Util.sleep(30);
            System.out.println("2: To Create Customer Account");

            Util.sleep(30);
            System.out.println("3: To login as IA");
            Util.sleep(30);
            System.out.println("9: To exit");
            System.out.print("Enter Your Choice : ");

            try {
                int n = Integer.parseInt(sc.nextLine());
                if(n==9){break;}
                Util.sleep(80);

                switch (n) {
                    case 1:
                        Control0.Interface();
                        break;
                    case 2:
                        Control0.CreateCustomer();
                        break;
                    case 3:
                        System.out.println("{IA Password is : " + pin + " }");
                        System.out.print("Enter The Authorised Pin (int): ");

                        try {
                            int p = Integer.parseInt(sc.nextLine());
                            Util.sleep(80);

                            while (p != pin) {
                                System.out.println("Wrong Pin | Enter 0 to exit");
                                System.out.print("Enter The Authorised Pin (int): ");

                                try {
                                    p = Integer.parseInt(sc.nextLine());
                                    Util.sleep(80);

                                    if (p == 0) {
                                        break;
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input. Please enter a valid integer.");
                                }
                            }
                            if (p != 0) {
                                while (Control0.iaInterface() == 1);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                        }

                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer choice.");
            }

        }
    }
}
