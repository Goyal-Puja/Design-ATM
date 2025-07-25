package com.atm.service;

import LowLevelDesign.DesignATM.*;
import LowLevelDesign.DesignATM.ATMStates.ATMState;
import com.atm.dto.*;
import org.springframework.stereotype.Service;

@Service
public class ATMService {
    
    private ATM atm;
    private User currentUser;
    private boolean cardInserted = false;
    private boolean authenticated = false;
    
    public ATMService() {
        initializeATM();
    }
    
    private void initializeATM() {
        atm = ATM.getAtmObject();
        atm.setAtmBalance(50000, 10, 20, 15); // Initialize with some cash
        
        // Create a default user for demo
        currentUser = createUser();
    }
    
    private User createUser() {
        User user = new User();
        Card card = new Card();
        UserBankAccount bankAccount = new UserBankAccount();
        bankAccount.balance = 25000;
        card.setBankAccount(bankAccount);
        user.setCard(card);
        return user;
    }
    
    public ATMResponse insertCard(String cardNumber) {
        try {
            if (cardInserted) {
                return new ATMResponse(false, "Card already inserted", null);
            }
            
            atm.getCurrentATMState().insertCard(atm, currentUser.getCard());
            cardInserted = true;
            
            return new ATMResponse(true, "Card inserted successfully. Please enter your PIN.", null);
        } catch (Exception e) {
            return new ATMResponse(false, "Error inserting card: " + e.getMessage(), null);
        }
    }
    
    public ATMResponse authenticatePin(int pin) {
        try {
            if (!cardInserted) {
                return new ATMResponse(false, "Please insert card first", null);
            }
            
            if (authenticated) {
                return new ATMResponse(false, "Already authenticated", null);
            }
            
            atm.getCurrentATMState().authenticatePin(atm, currentUser.getCard(), pin);
            
            if (currentUser.getCard().isCorrectedPINEntered(pin)) {
                authenticated = true;
                return new ATMResponse(true, "PIN verified successfully. Please select an operation.", null);
            } else {
                return new ATMResponse(false, "Invalid PIN. Please try again.", null);
            }
        } catch (Exception e) {
            return new ATMResponse(false, "Authentication error: " + e.getMessage(), null);
        }
    }
    
    public ATMResponse selectOperation(String operation) {
        try {
            if (!authenticated) {
                return new ATMResponse(false, "Please authenticate first", null);
            }
            
            TransactionType transactionType;
            if ("CASH_WITHDRAWAL".equals(operation)) {
                transactionType = TransactionType.CASH_WITHDRAWAL;
                atm.getCurrentATMState().selectOperation(atm, currentUser.getCard(), transactionType);
                return new ATMResponse(true, "Withdrawal selected. Please enter amount.", null);
            } else if ("BALANCE_CHECK".equals(operation)) {
                transactionType = TransactionType.BALANCE_CHECK;
                atm.getCurrentATMState().selectOperation(atm, currentUser.getCard(), transactionType);
                return checkBalance();
            } else {
                return new ATMResponse(false, "Invalid operation", null);
            }
        } catch (Exception e) {
            return new ATMResponse(false, "Operation error: " + e.getMessage(), null);
        }
    }
    
    public ATMResponse withdraw(int amount) {
        try {
            if (!authenticated) {
                return new ATMResponse(false, "Please authenticate first", null);
            }
            
            if (atm.getAtmBalance() < amount) {
                return new ATMResponse(false, "Insufficient funds in ATM", null);
            }
            
            if (currentUser.getCard().getBankBalance() < amount) {
                return new ATMResponse(false, "Insufficient funds in your account", null);
            }
            
            if (amount % 100 != 0) {
                return new ATMResponse(false, "Amount must be multiple of 100", null);
            }
            
            atm.getCurrentATMState().cashWithdrawal(atm, currentUser.getCard(), amount);
            
            WithdrawalResult result = new WithdrawalResult();
            result.setAmount(amount);
            result.setRemainingBalance(currentUser.getCard().getBankBalance());
            
            return new ATMResponse(true, "Withdrawal successful. Please collect your cash.", result);
        } catch (Exception e) {
            return new ATMResponse(false, "Withdrawal error: " + e.getMessage(), null);
        }
    }
    
    public ATMResponse checkBalance() {
        try {
            if (!authenticated) {
                return new ATMResponse(false, "Please authenticate first", null);
            }
            
            BalanceResult result = new BalanceResult();
            result.setBalance(currentUser.getCard().getBankBalance());
            
            return new ATMResponse(true, "Balance inquiry successful", result);
        } catch (Exception e) {
            return new ATMResponse(false, "Balance check error: " + e.getMessage(), null);
        }
    }
    
    public ATMStatus getATMStatus() {
        ATMStatus status = new ATMStatus();
        status.setAtmBalance(atm.getAtmBalance());
        status.setTwoThousandNotes(atm.getNoOfTwoThousandNotes());
        status.setFiveHundredNotes(atm.getNoOfFiveHundredNotes());
        status.setOneHundredNotes(atm.getNoOOneHundredNotes());
        status.setCardInserted(cardInserted);
        status.setAuthenticated(authenticated);
        return status;
    }
    
    public ATMResponse exit() {
        try {
            atm.getCurrentATMState().exit(atm);
            cardInserted = false;
            authenticated = false;
            return new ATMResponse(true, "Thank you for using our ATM. Please collect your card.", null);
        } catch (Exception e) {
            return new ATMResponse(false, "Exit error: " + e.getMessage(), null);
        }
    }
}