package com.example.SHSWEDEN.Repos;

import com.example.SHSWEDEN.Entities.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation, Integer> {
}