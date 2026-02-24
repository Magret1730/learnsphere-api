package org.codewithmagret.rest.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        if (category == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category created = categoryService.addCategory(category);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category updated) {
        Category saved = categoryService.updateCategory(id, updated);
        if (saved == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        boolean deleted = categoryService.deleteCategory(id);
        if (!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
