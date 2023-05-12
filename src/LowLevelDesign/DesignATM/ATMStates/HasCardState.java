package LowLevelDesign.DesignATM.ATMStates;

import LowLevelDesign.DesignATM.ATM;
import LowLevelDesign.DesignATM.Card;

public class HasCardState extends ATMState{
    public HasCardState(){
        System.out.println("Enter your card pin number");
    }
    @Override
    public void authenticatePin(ATM atm, Card card, int pin){
        boolean isCorrectedPinEntered = card.isCorrectedPINEntered(pin);
        if(isCorrectedPinEntered){
            atm.setCurrentATMState(new SelectOperationState());
        }
        else{
            System.out.println("Invalid Pin Number !!");
            exit(atm);
        }
    }

    @Override
    public void exit(ATM atm){
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exit Happens");
    }
    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }
}
