package com.atm.dto;

public class ATMStatus {
    private int atmBalance;
    private int twoThousandNotes;
    private int fiveHundredNotes;
    private int oneHundredNotes;
    private boolean cardInserted;
    private boolean authenticated;
    
    public int getAtmBalance() {
        return atmBalance;
    }
    
    public void setAtmBalance(int atmBalance) {
        this.atmBalance = atmBalance;
    }
    
    public int getTwoThousandNotes() {
        return twoThousandNotes;
    }
    
    public void setTwoThousandNotes(int twoThousandNotes) {
        this.twoThousandNotes = twoThousandNotes;
    }
    
    public int getFiveHundredNotes() {
        return fiveHundredNotes;
    }
    
    public void setFiveHundredNotes(int fiveHundredNotes) {
        this.fiveHundredNotes = fiveHundredNotes;
    }
    
    public int getOneHundredNotes() {
        return oneHundredNotes;
    }
    
    public void setOneHundredNotes(int oneHundredNotes) {
        this.oneHundredNotes = oneHundredNotes;
    }
    
    public boolean isCardInserted() {
        return cardInserted;
    }
    
    public void setCardInserted(boolean cardInserted) {
        this.cardInserted = cardInserted;
    }
    
    public boolean isAuthenticated() {
        return authenticated;
    }
    
    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}