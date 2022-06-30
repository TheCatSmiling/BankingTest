package banks;

public class Bank {
    private double interestRate=8.5;
    private double transactionFees=10;
    private Customer [] customers= new Customer[1000];

    public void calculateInterest(Customer customer){
        Account a=customer.getAccount();
        double bal=a.getBalance();
        double interestAmount=bal*interestRate/100;
        double totalBalance=bal+interestAmount;
        System.out.println("Interest amount "+interestAmount+"Total money after interest"+totalBalance);
    }
    public double getInterestRate(){
        return interestRate;
    }
    public double getTransactionFees(){
        return transactionFees;
    }
    public Customer[] getCustomer(){
        return customers;
    }

}
