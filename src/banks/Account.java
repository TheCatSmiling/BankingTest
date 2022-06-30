package banks;

public class Account {
    private double balance=100;
    private String accountNumber;
    private boolean firstTime=true;

    public Account(double bal,String acc){
        if (bal>=100)
            balance=bal;

        accountNumber=acc;
    }

    public void deposit(double howMuch){
        if (howMuch>0) {
            balance = balance + howMuch;
            System.out.println(howMuch+" Was deposited on your account" + "the new balance is:" + balance);
        }
        else
            System.err.println("The deposit can be lower than 0");
    }
    public void withdraw(double howMuch){
        if (howMuch>=0){
            if (firstTime==true){
                double tempBalance=balance;
                tempBalance=tempBalance-howMuch;
                if (tempBalance>=100){
                    balance=balance-howMuch;
                }
                    else{
                        System.err.println("Not enough balance"+howMuch);
                        firstTime=false;
                }

            }else{
                Bank bank= new Bank();
                double tempBalance=balance;
                tempBalance=tempBalance-howMuch-bank.getTransactionFees();
                if (tempBalance>=100){
                    balance=balance-howMuch;
                }
                else{
                    System.err.println("Not enough balance"+howMuch);
                }
            }
        }
            else
                System.err.println("You don't have enough money");
    }


    public double getBalance(){
        return balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
}
