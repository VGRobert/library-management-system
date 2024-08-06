package com.example.library_management_system.controller;

import com.example.library_management_system.model.Category;
import com.example.library_management_system.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        return categoryRepository.findById(id)
                .map(category -> ResponseEntity.ok().body(category))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        return categoryRepository.findById(id)
                .map(category -> {
                    category.setName(categoryDetails.getName());
                    Category updatedCategory = categoryRepository.save(category);
                    return ResponseEntity.ok().body(updatedCategory);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        return categoryRepository.findById(id)
                .map(category -> {
                    categoryRepository.delete(category);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
