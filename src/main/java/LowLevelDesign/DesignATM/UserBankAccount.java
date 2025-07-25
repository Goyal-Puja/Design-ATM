package LowLevelDesign.DesignATM;

public class UserBankAccount {
    public int balance;

    public void withdrawalBalance(int amount) {
        balance = balance - amount;
    }
    
    public int getBalance() {
        return balance;
    }
    
    public void setBalance(int balance) {
        this.balance = balance;
    }
}
