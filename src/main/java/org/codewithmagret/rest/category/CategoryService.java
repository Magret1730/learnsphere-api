package org.codewithmagret.rest.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category addCategory(Category category) {
        category.setId(null);
        category.setName(category.getName() == null ? null : category.getName().trim());

        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category categoryToUpdate) {
        Category categoryFound = categoryRepository.findById(id).orElse(null);

        if (categoryFound == null) {
            return null;
        }

        categoryFound.setName(categoryToUpdate.getName() == null ? null : categoryToUpdate.getName().trim());

        return categoryRepository.save(categoryFound);
    }

    public boolean deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            return false;
        }

        categoryRepository.deleteById(id);
        return true;
    }
}
