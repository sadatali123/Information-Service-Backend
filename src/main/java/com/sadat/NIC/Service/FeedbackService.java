package com.sadat.NIC.Service;

import com.sadat.NIC.DTO.FeedbackDTO;
import com.sadat.NIC.Entity.Feedback;
import com.sadat.NIC.Repository.FeedbackRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public Feedback addFeedback(FeedbackDTO feedbackDTO) {
        Feedback feedback = new Feedback();
        feedback.setRating(feedbackDTO.getRating());
        feedback.setRemark(feedbackDTO.getRemark());
        return feedbackRepository.save(feedback);
    }

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Optional<Feedback> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }
}
