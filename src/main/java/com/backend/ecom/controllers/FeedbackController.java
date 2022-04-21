package com.backend.ecom.controllers;

import com.backend.ecom.dto.feedback.FeedbackDTO;
import com.backend.ecom.dto.feedback.FeedbackRequestDTO;
import com.backend.ecom.entities.Feedback;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/feedbacks")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/all")
    public List<FeedbackDTO> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }

    @PutMapping("/update/{feedbackId}")
    public ResponseEntity<ResponseObject> updateFeedback(@Valid @PathVariable("feedbackId") Long feedbackId,
                                                         @Valid @RequestBody FeedbackRequestDTO feedbackRequest) {
        return feedbackService.updateFeedback(feedbackId, feedbackRequest);
    }

}
