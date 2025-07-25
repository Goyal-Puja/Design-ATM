package com.atm.controller;

import com.atm.dto.*;
import com.atm.service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ATMController {
    
    @Autowired
    private ATMService atmService;
    
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @PostMapping("/api/insert-card")
    @ResponseBody
    public ATMResponse insertCard(@RequestBody CardRequest request) {
        return atmService.insertCard(request.getCardNumber());
    }
    
    @PostMapping("/api/authenticate")
    @ResponseBody
    public ATMResponse authenticatePin(@RequestBody AuthRequest request) {
        return atmService.authenticatePin(request.getPin());
    }
    
    @PostMapping("/api/select-operation")
    @ResponseBody
    public ATMResponse selectOperation(@RequestBody OperationRequest request) {
        return atmService.selectOperation(request.getOperation());
    }
    
    @PostMapping("/api/withdraw")
    @ResponseBody
    public ATMResponse withdraw(@RequestBody WithdrawRequest request) {
        return atmService.withdraw(request.getAmount());
    }
    
    @GetMapping("/api/balance")
    @ResponseBody
    public ATMResponse checkBalance() {
        return atmService.checkBalance();
    }
    
    @GetMapping("/api/status")
    @ResponseBody
    public ATMStatus getATMStatus() {
        return atmService.getATMStatus();
    }
    
    @PostMapping("/api/exit")
    @ResponseBody
    public ATMResponse exit() {
        return atmService.exit();
    }
}