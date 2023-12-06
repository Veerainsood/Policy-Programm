import java.util.Arrays;

public class Customer {
    private String name;
    private String address;
    private String phoneNum;
    private int salary;
    private String userId;
    private String Password;
    private String[] incident =new String[3];
    private int[] premium={0,0,0};//0 for normal 1 for premium
    private int[] status ={0,0,0};// 0 for not given 1 for rejected 2 for given the policy 3 for claim pending 4 for claim amount already granted
    // 0 for rejected/not approved 1 for pending

    public Customer(String name, String address, String phoneNum,  String userId, String Password, int salary) {
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
         this.salary = salary;
        this.Password = Password;
        this.userId = userId;
    }
    public void ViewDetails(int f){

        System.out.println("UserId : "+userId);
        if(f==1){
            System.out.println("Password : "+Password);
        }
        System.out.println("Name : "+name);
        System.out.println("Address : "+this.address);
        System.out.println("Phone Number : "+phoneNum);
        System.out.println("Salary : "+salary);
        int j=0;
        for(int i : status) {
            if(i!=0)
                System.out.println(Util.arr2[j] + " Status : " + Util.arr[i]);
            j++;
        }

        j=0;
        for(String i : incident) {
            if(status[j]!=0)
                System.out.println(Util.arr2[j] + " Incident : " + i);
            j++;
        }
        j=0;
        for(int i : status) {
            if(i!=0)
                try {
                    System.out.println(Util.arr2[j] + " Maximum Claim : " + Policy.amount[j][premium[j]]);
                }catch (Exception e) {
                    System.out.println(i + " " + j + " " + Arrays.toString(Util.arr) + " " + Arrays.deepToString(homeInsurance.amount));
                }
            j++;
        }
    }
    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for phoneNum
    public String getPhoneNum() {
        return phoneNum;
    }

    // Setter for phoneNum
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    // Getter for salary
    public int getSalary() {
        return salary;
    }

    // Setter for salary
    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    
    // Getter for userId
    public String getUserId() {
        return userId;
    }

    // Setter for userId
    public void setUserId(String userId) {
        this.userId = userId;
    }

    // Getter for password
    public String getPassword() {
        return Password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.Password = password;
    }

    //0=inactive | 1=active | 2=pending
    public void setStatus(int PolicyIndex, int SetVal){
        status[PolicyIndex] = SetVal;
    }
    public int getStatus(int PolicyIndex)
    {
        return status[PolicyIndex];
    }
    
    public void Setincident(String incident, int k){//set Value of incident takes int parameter
        this.incident[k]=incident;
    }
    public int getPremium(int ind){
        return premium[ind];
    }
    public void setPremium(int premium,int ind)
    {
        this.premium[ind]=premium;
    }

    public void resetVal(int n) {
        incident[n]=null;
        premium[n]=0;
        status[n]=0;
    }
}

