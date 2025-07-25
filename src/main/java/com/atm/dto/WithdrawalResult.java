package com.atm.dto;

public class WithdrawalResult {
    private int amount;
    private int remainingBalance;
    
    public int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public int getRemainingBalance() {
        return remainingBalance;
    }
    
    public void setRemainingBalance(int remainingBalance) {
        this.remainingBalance = remainingBalance;
    }
}