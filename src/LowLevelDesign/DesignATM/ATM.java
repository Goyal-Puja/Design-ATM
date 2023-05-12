package LowLevelDesign.DesignATM;

import LowLevelDesign.DesignATM.ATMStates.ATMState;

public class ATM {
    private static ATM atmObject = new ATM();
    ATMState currentATMState;

    private ATM(){

    }
    public void setCurrentATMState(ATMState currentATMState){
        this.currentATMState = currentATMState;
    }
    public ATMState getCurrentATMState(){
        return currentATMState;
    }
}
