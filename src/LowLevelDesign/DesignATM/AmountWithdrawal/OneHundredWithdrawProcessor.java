package LowLevelDesign.DesignATM.AmountWithdrawal;

import LowLevelDesign.DesignATM.ATM;

public class OneHundredWithdrawProcessor extends CashWithdrawProcessor{
    public OneHundredWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor){
        super(cashWithdrawProcessor);
    }
    public void withdraw(ATM atm, int remainingAmount){
        int required = remainingAmount/100;
        int balance = remainingAmount%100;

        if(required <= atm.getNoOOneHundredNotes()){
            atm.deductOneHundredNotes(required);
        }
        else if(required > atm.getNoOOneHundredNotes()){
            atm.deductOneHundredNotes(atm.getNoOOneHundredNotes());
            balance = balance+(required-atm.getNoOOneHundredNotes())*100;
        }
        if(balance != 0){
            super.withdraw(atm,balance);
        }
    }
}
