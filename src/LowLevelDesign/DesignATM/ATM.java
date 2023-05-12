package LowLevelDesign.DesignATM;

import LowLevelDesign.DesignATM.ATMStates.ATMState;
import LowLevelDesign.DesignATM.ATMStates.IdleState;

public class ATM {
    private static ATM atmObject = new ATM();
    ATMState currentATMState;
    private int atmBalance;
    int noOfFiveHundredNotes;
    int noOfOneHundredNotes;
    int noOfTwoThousandNotes;

    private ATM(){

    }
    public void setCurrentATMState(ATMState currentATMState){
        this.currentATMState = currentATMState;
    }
    public ATMState getCurrentATMState(){
        return currentATMState;
    }
    public static ATM getAtmObject(){
        atmObject.setCurrentATMState(new IdleState());
        return atmObject;
    }
    public void setAtmBalance(int atmBalance,int noOfFiveHundredNotes,int noOfOneHundredNotes,int noOfTwoThousandNotes){
        this.atmBalance = atmBalance;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;

    }
    public int getAtmBalance(){
        return atmBalance;
    }
    public void deductATMBalance(int amount){
        atmBalance = atmBalance-amount;
    }
    public int getNoOfFiveHundredNotes(){
        return noOfFiveHundredNotes;
    }
    public int getNoOOneHundredNotes(){
        return noOfOneHundredNotes;
    }
    public int getNoOfTwoThousandNotes(){
        return noOfTwoThousandNotes;
    }
    public void deductFiveHundredNotes(int number){
        noOfFiveHundredNotes = noOfFiveHundredNotes-number;
    }
    public void deductOneHundredNotes(int number){
        noOfOneHundredNotes = noOfOneHundredNotes-number;
    }
    public void deductTwoThousandNotes(int number){
        noOfTwoThousandNotes = noOfTwoThousandNotes-number;
    }
    public void printCurrentATMStatus(){
        System.out.println("Balance: "+atmBalance);
        System.out.println("No of Two Thousand : "+noOfTwoThousandNotes);
        System.out.println("No of One Hundred : "+noOfOneHundredNotes);
        System.out.println("No of Five Hundred : "+noOfFiveHundredNotes);
    }
}
