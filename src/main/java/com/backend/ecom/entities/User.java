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

    @Size(min = 10, max = 50)
    @NotBlank
    @Column(name = "fullName")
    private String fullName;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "username")
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(min = 6, max = 150)
    @Column(name = "password")
    private String password;

    @Size(max = 200)
    @Column(name = "address")
    private String address;

    @Size(max = 100)
    private String image;

    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "user_feedbacks",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "feedback_id"))
    private Set<Feedback> feedbacks = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "user_vouchers",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "voucher_id"))
    private Set<Voucher> vouchers = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Transaction> transactions;

    @Column(name = "created_at")
    private Timestamp creationDate;

    @Column(name = "updated_at")
    private Timestamp modifiedDate;

    private boolean deleted = Boolean.FALSE;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    public User(SignupRequest signUpRequest) {
        this.fullName = signUpRequest.getFullName();
        this.username = signUpRequest.getUsername();
        this.email = signUpRequest.getEmail();
        this.address = signUpRequest.getAddress();
    }


}
