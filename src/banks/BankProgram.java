package banks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BankProgram {
    public static void main (String[]args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCustomers = 0;
        Bank bank = new Bank();
        Customer[] c= bank.getCustomer();

        while (true){
            System.out.println("Please enter your choice: ");
            System.out.println("1: Add costumer ");
            System.out.println("2: Deposit money ");
            System.out.println("3: Withdraw money ");
            System.out.println("4: Check balance ");
            System.out.println("5:Calculate interest");
            System.out.println("6: Exit");

            int choice = Integer.parseInt(bufferedReader.readLine());
            switch (choice) {
                case 1:
                    System.out.println("Creating an account for a new costumer: ");
                    System.out.println("Please enter the initial amount in your account: ");
                    double bal = Double.parseDouble(bufferedReader.readLine());
                    System.out.println("Please enter your account number: ");
                    String acc =  bufferedReader.readLine();
                    Account account = new Account(bal,acc);
                    System.out.println("Please enter your name: ");
                    String name = bufferedReader.readLine();
                    Customer customer = new Customer(name,account);
                    c[numberOfCustomers]=customer;
                    numberOfCustomers++;
                    System.err.println("NUMBER OF CUSTOMERS "+numberOfCustomers);
                    for (int i = 0;i<numberOfCustomers;i++){
                        System.err.println(c[i].getName()+" NAME");
                    }
                    break;
                case 2:
                    System.out.println("Enter account number");
                    acc = bufferedReader.readLine();
                    if (numberOfCustomers==0)
                        System.out.println("Account number not found");
                    else {
                        boolean found = false;
                        for (int i = 0; i < numberOfCustomers; i++) {
                            Account temp = c[i].getAccount();
                            String accTemp = temp.getAccountNumber();
                            if(accTemp.equals(acc)){
                                System.out.println("Enter the amount to deposit");
                                double money = Double.parseDouble(bufferedReader.readLine());
                                temp.deposit(money);
                                found=true;
                            }
                        }
                        if(!found){
                            System.err.println("Account number not found");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter account number");
                    acc = bufferedReader.readLine();
                    if (numberOfCustomers==0)
                        System.out.println("Account number not found");
                    else {
                        boolean found = false;
                        for (int i = 0; i < numberOfCustomers; i++) {
                            Account temp = c[i].getAccount();
                            String accTemp = temp.getAccountNumber();
                            if(accTemp.equals(acc)){
                                System.out.println("Enter the amount to withdraw");
                                double money = Double.parseDouble(bufferedReader.readLine());
                                temp.withdraw(money);
                                found=true;
                            }
                        }
                        if(!found){
                            System.err.println("Account number not found");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter account number");
                    acc = bufferedReader.readLine();
                    if (numberOfCustomers==0)
                        System.out.println("Account number not found");
                    else {
                        boolean found = false;
                        for (int i = 0; i < numberOfCustomers; i++) {
                            Account temp = c[i].getAccount();
                            String accTemp = temp.getAccountNumber();
                            if(accTemp.equals(acc)){
                                System.out.println("Your balance is : "+temp.getBalance());
                                found=true;
                            }
                        }
                        if(!found){
                            System.err.println("Account number not found");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Enter account number");
                    acc = bufferedReader.readLine();
                    if (numberOfCustomers==0)
                        System.out.println("Account number not found");
                    else {
                        boolean found = false;
                        for (int i = 0; i < numberOfCustomers; i++) {
                            Account temp = c[i].getAccount();
                            String accTemp = temp.getAccountNumber();
                            if(accTemp.equals(acc)){
                                bank.calculateInterest(c[i]);
                                found=true;
                            }
                        }
                        if(!found){
                            System.err.println("Account number not found");
                        }
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
