package com.backend.ecom.dto;

import com.backend.ecom.entities.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDetailDTO {
    private Long id;
    private String fullName;
    private String username;
    private String email;
    private String address;
    private String image;
    private Set<Role> roles;
    private Set<Feedback> feedbacks;
    private Set<Voucher> vouchers;
    private Set<Transaction> transactions;
    private Timestamp creationDate;
    private Timestamp modifiedDate;

    public UserDetailDTO (User user) {
        this.id = user.getId();
        this.fullName = user.getFullName();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.image = user.getImage();
        this.roles = user.getRoles();
        this.feedbacks = user.getFeedbacks();
        this.vouchers = user.getVouchers();
        this.transactions = user.getTransactions();
        this.creationDate = user.getCreationDate();
        this.modifiedDate = user.getModifiedDate();
    }
}
