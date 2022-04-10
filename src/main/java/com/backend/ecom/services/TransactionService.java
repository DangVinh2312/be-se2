package com.backend.ecom.services;

import com.backend.ecom.entities.Brand;
import com.backend.ecom.entities.Transaction;
import com.backend.ecom.exception.ResourceNotFoundException;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;


    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public ResponseEntity<ResponseObject> getTransactionDetail(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete transaction successfully", ""));
    }

    public ResponseEntity<ResponseObject> updateTransaction(Long id, Transaction transactionRequest) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found brand with id:" + id));
//        transaction.setName(transactionRequest.getName());
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete transaction successfully", ""));
    }

    public ResponseEntity<ResponseObject> deleteTransaction(Long id) {
        if (!transactionRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found transaction with id:" + id);
        }
        transactionRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete transaction successfully", ""));

    }

}
