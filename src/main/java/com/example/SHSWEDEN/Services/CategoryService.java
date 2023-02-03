package com.example.SHSWEDEN.Services;

import com.example.SHSWEDEN.Entities.Category;
import com.example.SHSWEDEN.Repos.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findByParentId(Integer parentId) {

        List<Category> categories = categoryRepository.findByParentId(parentId);
        return categories;
    }
}
