package atminterface;

import java.util.Scanner;

public class AtmInterface{
   Scanner sca = new Scanner(System.in);
   
    String UserID;
    double transactionHistory;
    double balance = 0; // initial balance to 0 for every client
    int anotherTransaction;
    int UserPin;
    
    
   public void mainMenu() {
        // here is where most of the work is

        int option;
        Scanner sca = new Scanner(System.in);
                   
        
        System.out.println("Please select an option");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Balance");
        System.out.println("4. Trasanction History");
        System.out.println("5. Cancel");

        option = sca.nextInt();

        switch (option) {
            case 1:
                float amount;
                System.out.println("Please enter amount to withdraw: ");
                amount = sca.nextFloat();
                if (amount > balance || amount == 0) {
                    System.out.println("You have insufficient funds\n\n");
                    anotherTransaction(); // ask if they want another transaction
                } else {
                    // they have some cash
                    // update balance
                    balance = balance - amount;
                    System.out.println("You have withdrawn " + amount + " and your new balance is " + balance + "\n");
                    System.out.println("---------------------------------------------------------------------------");
                    anotherTransaction();
                }
                break;

            case 2:
                // option number 2 is depositing
                float deposit;
                System.out.println("Please enter amount to deposit: ");
                deposit = sca.nextFloat();
                // update balance
                balance = deposit + balance;
                System.out.println("You have deposited " + deposit + "\n" + "new balance: " + balance + "\n");
                System.out.println("-----------------------------------------------------------------------");
                anotherTransaction();
                break;

            case 3:
                // this option is to check balance
                System.out.println("Your balance is " + balance + "\n");
                anotherTransaction();
                break;
            
            case 4: 
                System.out.println("-----------------------------------------------------------------------");
                getTransactionHistory();
                System.out.println("-----------------------------------------------------------------------");
                break;
                
            default:
                System.out.println("Invalid option:\n\n");
                anotherTransaction();
                break;
        }

    }
    void getTransactionHistory(){
        if(transactionHistory > 0){
            System.out.println("Amount Deposited: "+ transactionHistory);
            
        }
        else if (transactionHistory < 0){
            System.out.println("Withdrawal of: "+ Math.abs(transactionHistory));
        }
        else {
            System.out.println("No Transaction History");
        }    
    }

    void anotherTransaction() {
        System.out.println("Do you want another transaction?\n\nPress 1 for another transaction\n2 To exit");
        anotherTransaction = sca.nextInt();
        if (anotherTransaction == 1) {
            mainMenu(); // call transaction method
        } else if (anotherTransaction == 2) {
            System.out.println("Thank you for using ATM. Good Bye!");
        } else {
            System.out.println("Invalid choice\n\n");
            anotherTransaction();
        }
    }
    void UserID(){
        System.out.println("Please enter your UserID:");
        String UserID = sca.next();
        
        if (UserID.equals("Tlhogi")) {
            UserPin();
        }
        else{
            System.out.println("UserID Invalid");
            UserID();
        }
        
    }
    void UserPin(){
        System.out.println("Please enter Pin:");
        int UserPin = sca.nextInt();
        
        if(UserPin == 38073){
            mainMenu();
        }
        else{
            System.out.println("UserPin Invalid");
            UserID();
        }
    }
    
     public static void main(String args[]) {
        

        // calling mainMenu method here
        new AtmInterface().UserID();
        new AtmInterface().UserPin();
       new AtmInterface().mainMenu();
    }
}
