package com.backend.ecom.dto.user;

import com.backend.ecom.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
public class UserShortInfoDTO {
    private Long id;
    private String ava;
    private String fullName;

    private String username;
    private String address;
    private LocalDateTime updatedAt;

    public UserShortInfoDTO(User user) {
        this.id = user.getId();
        this.ava = user.getAva();
        this.fullName = user.getFullName();
        this.username = user.getUsername();
        this.address = user.getAddress();
        this.updatedAt = user.getUpdatedDate();
    }

}

