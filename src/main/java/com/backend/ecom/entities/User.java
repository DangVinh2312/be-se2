package com.backend.ecom.entities;

import com.backend.ecom.dto.user.UserCreateRequestDTO;
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

    @Lob
    private String ava;

    private String fullName;

    private String username;

    private String email;

    @JsonIgnore
    private String password;

    private String address;

    @ManyToOne
    private Role role;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
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
    @JsonIgnore
    private Cart cart;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
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

    public User(UserCreateRequestDTO userCreateRequestDTO) {
        this.fullName = userCreateRequestDTO.getFullName();
        this.username = userCreateRequestDTO.getUsername();
        this.email = userCreateRequestDTO.getEmail();
    }

    public void addFeedback(Feedback feedback) {
        this.feedbacks.add(feedback);
        feedback.setUser(this);
    }

    public void removeFeedback(Long feedbackId) {
        Feedback feedback = this.feedbacks.stream().filter(t -> t.getId() == feedbackId).findFirst().orElse(null);
        if (feedback != null) this.feedbacks.remove(feedback);
        feedback.setUser(null);
    }

}
