package com.backend.ecom.services;

import com.backend.ecom.entities.Feedback;
import com.backend.ecom.exception.ResourceNotFoundException;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.repositories.FeedbackRepository;
import com.backend.ecom.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    public FeedbackRepository feedbackRepository;

    @Autowired
    public UserRepository userRepository;


    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public ResponseEntity<ResponseObject> getFeedbackDetail(Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Query feedback successfully", ""));
    }

    public ResponseEntity<ResponseObject> updateFeedback(Long id, Feedback feedbackRequest) {
        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found feedback with id:" + id));
        feedback.setContent(feedbackRequest.getContent());
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Update feedback successfully", ""));
    }

    public ResponseEntity<ResponseObject> deleteFeedback(Long id) {
        if (!feedbackRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found feedback with id:" + id);
        }
        feedbackRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete feedback successfully", ""));

    }

}
