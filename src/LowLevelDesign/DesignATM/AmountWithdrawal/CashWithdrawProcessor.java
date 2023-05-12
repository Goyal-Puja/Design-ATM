package LowLevelDesign.DesignATM.AmountWithdrawal;

import LowLevelDesign.DesignATM.ATM;

public abstract class CashWithdrawProcessor {
    CashWithdrawProcessor cashWithdrawProcessor;
    CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor){
        this.cashWithdrawProcessor = cashWithdrawProcessor;
    }
    public void withdraw(ATM atm,int remainingAmount){
        if(cashWithdrawProcessor != null){
            cashWithdrawProcessor.withdraw(atm,remainingAmount);
        }
    }
}
