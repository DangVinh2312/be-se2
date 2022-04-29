package com.backend.ecom.controllers;

import com.backend.ecom.dto.transaction.TransactionRequestDTO;

import com.backend.ecom.entities.Transaction;

import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.services.TransactionService;

import com.backend.ecom.supporters.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/all")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getTransactionDetail(@PathVariable("id") Long id) {
        return transactionService.getTransactionDetail(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateTransaction(@PathVariable("id") Long id, @RequestBody TransactionRequestDTO transactionRequest) {
        return transactionService.updateTransaction(id, transactionRequest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteTransaction(@PathVariable("id") Long id) {
        return transactionService.deleteTransaction(id);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseObject> newTransaction(@RequestBody TransactionRequestDTO transactionRequest) {
        return transactionService.createTransaction(transactionRequest);
    }

    @PutMapping("/payment")
    public ResponseEntity<ResponseObject> updateStatus(@PathVariable("id") Long id, @RequestBody TransactionStatus transactionStatus) {
        return transactionService.updatePayment(id, transactionStatus);
    }

}
