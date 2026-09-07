package com.banking.accountservice.controller;

import com.banking.accountservice.dto.AccountResponse;
import com.banking.accountservice.dto.CreateAccountRequest;
import com.banking.accountservice.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/account")
@Slf4j
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/create")     //     /api/v1/account/create
    public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody CreateAccountRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(request));
    }

    @GetMapping("/{accountNumber}")        // /api/v1/account/{accountNumber}
    public ResponseEntity<AccountResponse> getAccount(@PathVariable String accountNumber){
        return ResponseEntity.status(HttpStatus.OK).body(accountService.getAccount(accountNumber));
    }

    @GetMapping("/{accountNumber}/balance")     //  api/v1/account/{accountNumber}/balance
    public ResponseEntity<BigDecimal> getBalance(@PathVariable String accountNumber){
        return ResponseEntity.status(HttpStatus.OK).body(accountService.getBalance(accountNumber));
    }

    @PutMapping("/{accountNumber}/block")       //   api/v1/account/{accountNumber}/block
    public ResponseEntity<String> blockAccount(@PathVariable String accountNumber){
        accountService.blockAccount(accountNumber);
        return ResponseEntity.ok("Account blocked Successfully");
    }

    @PutMapping("/{accountNumber}/deduct")      //  api/v1/account/{accountNumber}/deduct
    public ResponseEntity<String> deductionBalance(@PathVariable String accountNumber, @RequestParam BigDecimal amount){
        accountService.deductBalance(accountNumber,amount);
        return ResponseEntity.ok("Balance deducted successfully");
    }

    @PutMapping("/{accountNumber}/credit")
    public ResponseEntity<String> creditBalance(@PathVariable String accountNumber, @RequestParam BigDecimal amount){
        accountService.creditBalance(accountNumber, amount);
        return ResponseEntity.ok("Balance Credit Successfully");
    }
}
