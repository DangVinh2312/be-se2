package com.backend.ecom.controllers;

import com.backend.ecom.entities.Feedback;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/feedbacks")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/all")
    public List<Feedback> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getFeedbackDetail(@PathVariable("id") Long id){
        return feedbackService.getFeedbackDetail(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateFeedback(@PathVariable("id") Long id, @RequestBody Feedback feedbackRequest) {
        return feedbackService.updateFeedback(id,feedbackRequest );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteFeedback(@PathVariable("id") Long id) {
        return feedbackService.deleteFeedback(id);
    }
}
