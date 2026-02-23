package org.codewithmagret.rest.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping()
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category categoryToUpdate) {
        return categoryService.updateCategory(id, categoryToUpdate);
    }

    @DeleteMapping("{id}")
    public void deleteCategoryById(@PathVariable Long id) {
        boolean deleted = categoryService.deleteCategoryById(id);

        if (!deleted) {
            throw new ResourceNotFoundException("Category with id " + id + " not found");
        }
    }
}
