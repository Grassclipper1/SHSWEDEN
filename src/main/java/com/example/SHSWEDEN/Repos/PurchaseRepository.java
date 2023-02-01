package com.example.SHSWEDEN.Repos;

import com.example.SHSWEDEN.Entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository <Purchase, Integer> {
}
