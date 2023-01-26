package com.example.SHSWEDEN.Repos;

import com.example.SHSWEDEN.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}