package LowLevelDesign.DesignATM;

import LowLevelDesign.DesignATM.ATMStates.ATMState;
import LowLevelDesign.DesignATM.ATMStates.IdleState;

public class ATM {
    private static ATM atmObject = new ATM();
    ATMState currentATMState;
    private int atmBalance;

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
    public int getAtmBalance(){
        return atmBalance;
    }
    public void deductATMBalance(int amount){
        atmBalance = atmBalance-amount;
    }
}
