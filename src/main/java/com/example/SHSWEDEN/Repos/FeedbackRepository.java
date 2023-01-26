package com.example.SHSWEDEN.Repos;

import com.example.SHSWEDEN.Entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}