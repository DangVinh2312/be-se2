package com.backend.ecom.controllers;

import com.backend.ecom.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
}
