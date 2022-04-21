package com.backend.ecom.dto.user;

import com.backend.ecom.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
public class UserShortInfoDTO {
    private Long id;
    private String ava;
    private String fullName;
    private String address;
    private Timestamp modifiedDate;
    private Timestamp deletedAt;

    public UserShortInfoDTO(User user) {
        this.id = user.getId();
        this.ava = user.getAva();
        this.fullName = user.getFullName();
        this.address = user.getAddress();
        this.modifiedDate = user.getUpdatedDate();
        this.deletedAt = user.getDeletedAt();
    }

}

