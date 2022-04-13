package com.backend.ecom.entities;

import com.backend.ecom.payload.request.SignupRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fullName;

    private String username;

    private String email;

    private String password;

    @Size(max = 200)
    private String address;

    @Size(max = 100)
    private String image;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Role> roles = new HashSet<>();

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


}
