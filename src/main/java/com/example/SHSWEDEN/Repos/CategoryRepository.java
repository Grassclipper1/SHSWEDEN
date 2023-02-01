package com.example.SHSWEDEN.Repos;

import com.example.SHSWEDEN.Entities.Category;
import com.example.SHSWEDEN.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByParentId(Integer parentId);

}