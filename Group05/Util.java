import java.util.Scanner;

public class Util {
    static String[] arr2 ={"Home Insurance", "Life Insurance", "Car Insurance"};
    // 0 for not given 1 for rejected 2 for given the policy 3 for claim pending 4 for claim amount already granted 5 for policy pending
    static String[] arr ={"NA", "Rejected", "Policy Granted", "Claim Pending", "Claim Approved"};
    public static void sleep(int x){
        try {
            Thread.sleep(x);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    static Scanner sc = new Scanner(System.in);
    static int getIntInput() {
        int input = -1;
        while (input == -1) {
            try {
                String s = sc.nextLine();
                for(int i = 0;i<s.length();i++){
                    char k = s.charAt(i);
                    if(k>'9'||k<'1'){
                        throw new InvalidInputExeption("Invalid input Exception");
                    }
                }
                input = Integer.parseInt(s);
            } catch (InvalidInputExeption e) {
                System.out.print("Please enter an integer : ");
//                sc.nextLine(); // Clear the input buffer
            }
        }
        Util.sleep(80); // Sleep for 80 milliseconds
        return input;
    }
}

