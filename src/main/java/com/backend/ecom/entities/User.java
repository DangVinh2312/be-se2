package com.backend.ecom.entities;

import com.backend.ecom.dto.user.UserRequestDTO;
import com.backend.ecom.payload.request.SignupRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ava;

    private String fullName;

    private String username;

    private String email;

    private String password;

    private String address;

    @ManyToOne
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Feedback> feedbacks = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "user_vouchers",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "voucherId"))
    private Set<Voucher> vouchers = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

    @OneToMany(mappedBy = "user")
    private Set<Transaction> transactions;

    private Timestamp creationDate;

    private Timestamp modifiedDate;

    private boolean deleted = Boolean.FALSE;

    private Timestamp deletedAt;

    public User(SignupRequest signUpRequest) {
        this.fullName = signUpRequest.getFullName();
        this.username = signUpRequest.getUsername();
        this.email = signUpRequest.getEmail();
        this.address = signUpRequest.getAddress();
    }

    public User(UserRequestDTO userRequestDTO) {
        this.fullName = userRequestDTO.getFullName();
        this.username = userRequestDTO.getUsername();
        this.email = userRequestDTO.getEmail();
    }

}
