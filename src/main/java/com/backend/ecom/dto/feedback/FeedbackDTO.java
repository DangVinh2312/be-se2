package com.backend.ecom.dto.feedback;

import com.backend.ecom.entities.Feedback;
import com.backend.ecom.entities.Product;
import com.backend.ecom.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class FeedbackDTO {

    private String content;

    private Integer rating;

    private User user;

    private Product product;

    private Timestamp createdDate;

    public FeedbackDTO(Feedback feedback){
        this.content = feedback.getContent();
        this.rating = feedback.getRating();
        this.user = feedback.getUser();
        this.product = feedback.getProduct();
        this.createdDate = feedback.getCreatedDate();
    }
}
