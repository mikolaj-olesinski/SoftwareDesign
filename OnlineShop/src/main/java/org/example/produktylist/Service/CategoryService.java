package org.example.produktylist.Service;

import org.example.produktylist.Entity.Category;
import org.example.produktylist.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serwis obsługujący kategorie produktów.
 */
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.getProducts().clear();
            categoryRepository.save(category);
            categoryRepository.delete(category);
        }
    }




}
