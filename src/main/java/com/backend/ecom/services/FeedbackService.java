package com.backend.ecom.services;

import com.backend.ecom.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {
    @Autowired
    public FeedbackRepository feedbackRepository;
}
