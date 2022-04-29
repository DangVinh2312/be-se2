package com.backend.ecom.services;

import com.backend.ecom.dto.transaction.TransactionDTO;
import com.backend.ecom.dto.transaction.TransactionRequestDTO;
import com.backend.ecom.entities.*;
import com.backend.ecom.exception.ResourceNotFoundException;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.repositories.TransactionRepository;
import com.backend.ecom.supporters.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;


    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public ResponseEntity<ResponseObject> getTransactionDetail(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found brand with id:" + id));

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete transaction successfully", new TransactionDTO(transaction)));
    }

    @Transactional
    public ResponseEntity<ResponseObject> updateTransaction(Long id, TransactionRequestDTO transactionRequest) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found brand with id:" + id));

        transaction.setUser(transactionRequest.getCart().getUser());
        transaction.setPaymentType(transactionRequest.getPaymentType());
        transaction.setStatus(transactionRequest.getStatus());
        transaction.setVoucher(transactionRequest.getVoucher());
        transaction.setTotalPrice(transactionRequest.getTotalPrice());
        transaction.setCart(transactionRequest.getCart());

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete transaction successfully", new TransactionDTO(transactionRepository.save(transaction))));
    }

    @Transactional
    public ResponseEntity<ResponseObject> deleteTransaction(Long id) {
        if (!transactionRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found transaction with id:" + id);
        }
        transactionRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete transaction successfully", ""));

    }

    @Transactional
    public ResponseEntity<ResponseObject> createTransaction(TransactionRequestDTO transactionRequest) {
        Set<CartItem> cartItem = transactionRequest.getCart().getCartItems();
        double price = 0;
        for (CartItem item : cartItem) {
            price = price + item.getTotalPrice();
        }
        price = Voucher.applyVoucher(price, transactionRequest.getVoucher());

        com.backend.ecom.entities.User user = transactionRequest.getCart().getUser();

        Transaction transaction = new Transaction(user, transactionRequest.getPaymentType(), transactionRequest.getStatus(), transactionRequest.getMessage(), transactionRequest.getVoucher(), price, transactionRequest.getCart());
        transactionRepository.save(transaction);
        user.getCart().clearCart();
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject("ok", "Transaction created!", new TransactionDTO(transaction)));
    }

    @Transactional
    public ResponseEntity<ResponseObject> updatePayment(Long id, TransactionStatus transactionStatus) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found brand with id:" + id));
        transaction.setStatus(transactionStatus);
        transactionRepository.save(transaction);
        return ResponseEntity.ok(new ResponseObject("ok", "Transaction status updated!", new TransactionDTO(transactionRepository.save(transaction))));
    }

}
