package com.backend.ecom.services;

import com.backend.ecom.entities.*;
import com.backend.ecom.exception.ResourceNotFoundException;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.repositories.TransactionRepository;
import com.backend.ecom.supporters.PaymentType;
import com.backend.ecom.supporters.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

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
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete transaction successfully", ""));
    }

    public ResponseEntity<ResponseObject> updateTransaction(Long id, Transaction transactionRequest) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found brand with id:" + id));

        transaction.setUser(transactionRequest.getUser());
        transaction.setPaymentType(transactionRequest.getPaymentType());
        transaction.setStatus(transactionRequest.getStatus());
        transaction.setVoucher(transactionRequest.getVoucher());
        transaction.setTotalPrice(transactionRequest.getTotalPrice());
        transaction.setCart(transactionRequest.getCart());

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete transaction successfully", transactionRepository.save(transaction)));
    }

    public ResponseEntity<ResponseObject> deleteTransaction(Long id) {
        if (!transactionRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found transaction with id:" + id);
        }
        transactionRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete transaction successfully", ""));

    }

    public ResponseEntity<ResponseObject> createTransaction(Cart cart, Voucher appliedVoucher, String message, PaymentType paymentType, TransactionStatus transactionStatus){
        Set<CartItem>  cartItem = cart.getCartItems();
        double price = 0;
        for (CartItem item : cartItem){
            price = price + item.getTotalPrice();
        }

        price = Voucher.applyVoucher(price, appliedVoucher);

        com.backend.ecom.entities.User user = cart.getUser();

        Transaction transaction = new Transaction(user, paymentType,transactionStatus, message, appliedVoucher, price, cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject("ok", "Transaction created!", transaction));
    }

    public ResponseEntity<ResponseObject> updatePayment(Long id, TransactionStatus transactionStatus){
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found brand with id:" + id));
        transaction.setStatus(transactionStatus);
        transactionRepository.save(transaction);
        return ResponseEntity.ok( new ResponseObject("ok", "Transaction status updated!", transaction));
    }

}
