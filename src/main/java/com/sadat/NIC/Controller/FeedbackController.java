package com.sadat.NIC.Controller;

import com.sadat.NIC.DTO.FeedbackDTO;
import com.sadat.NIC.Entity.Feedback;
import com.sadat.NIC.Service.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedbacks")
@CrossOrigin(origins = "*") // add CORS for frontend
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/add")
    public ResponseEntity<Feedback> addFeedback(@RequestBody FeedbackDTO feedbackDTO) {
        return ResponseEntity.ok(feedbackService.addFeedback(feedbackDTO));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        return ResponseEntity.ok(feedbackService.getAllFeedbacks());
    }

    @GetMapping("getbyid/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
        Optional<Feedback> feedback = feedbackService.getFeedbackById(id);
        return feedback.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
