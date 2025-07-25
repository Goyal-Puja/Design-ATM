package LowLevelDesign.DesignATM.ATMStates;

import LowLevelDesign.DesignATM.ATM;
import LowLevelDesign.DesignATM.AmountWithdrawal.CashWithdrawProcessor;
import LowLevelDesign.DesignATM.AmountWithdrawal.FiveHundredWithdrawProcessor;
import LowLevelDesign.DesignATM.AmountWithdrawal.OneHundredWithdrawProcessor;
import LowLevelDesign.DesignATM.AmountWithdrawal.TwoThousandWithdrawProcessor;
import LowLevelDesign.DesignATM.Card;

public class CashWithdrawalState extends ATMState {
    public CashWithdrawalState() {
        System.out.println("Please Enter the withdrawal amount");
    }

    public void cashWithdrawal(ATM atmObject, Card card, int withdrawalAmount) {
        if (atmObject.getAtmBalance() < withdrawalAmount) {
            System.out.println("Insufficient Fund in the ATM Machine");
            exit(atmObject);
        } else if (card.getBankBalance() < withdrawalAmount) {
            System.out.println("Insufficient Fund in your Bank Account");
            exit(atmObject);
        } else {
            card.deductBankBalance(withdrawalAmount);
            atmObject.deductATMBalance(withdrawalAmount);

            CashWithdrawProcessor withdrawProcessor =
                    new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));
            withdrawProcessor.withdraw(atmObject, withdrawalAmount);
            exit(atmObject);
        }
    }

    @Override
    public void exit(ATM atmObject) {
        returnCard();
        atmObject.setCurrentATMState(new IdleState());
        System.out.println("Exit Happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
