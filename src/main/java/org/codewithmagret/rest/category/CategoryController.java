package org.codewithmagret.rest.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing categories.
 */
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * Default constructor for CategoryController.
     */
    public CategoryController() {
    }

    /**
     * Retrieves a list of all categories.
     *
     * @return A list of Category objects.
     */
    @GetMapping()
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    /**
     * Retrieves a category by its ID.
     *
     * @param id The ID of the category to retrieve.
     * @return A ResponseEntity containing the Category object if found, or a 404 Not Found status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        if (category == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(category);
    }

    /**
     * Creates a new category.
     *
     * @param category The Category object to create.
     * @return A ResponseEntity containing the created Category object.
     */
    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category created = categoryService.addCategory(category);
        return ResponseEntity.ok(created);
    }

    /**
     * Updates an existing category.
     *
     * @param id      The ID of the category to update.
     * @param updated The Category object containing the updated data.
     * @return A ResponseEntity containing the updated Category object if found, or a 404 Not Found status if not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category updated) {
        Category saved = categoryService.updateCategory(id, updated);
        if (saved == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(saved);
    }

    /**
     * Deletes a category by its ID.
     *
     * @param id The ID of the category to delete.
     * @return A ResponseEntity with a 204 No Content status if deleted, or a 404 Not Found status if not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        boolean deleted = categoryService.deleteCategory(id);
        if (!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
