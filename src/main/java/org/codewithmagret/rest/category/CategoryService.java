package org.codewithmagret.rest.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for handling business logic related to Category entities.
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Default constructor for CategoryService.
     */
    public CategoryService() {
    }

    /**
     * Retrieves all categories from the repository.
     *
     * @return a list of all categories
     */
    public List<Category> getCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    /**
     * Retrieves a category by its ID.
     *
     * @param id the ID of the category to retrieve
     * @return the Category object if found, or null if not found
     */
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    /**
     * Adds a new category to the repository.
     *
     * @param category the Category object to add
     * @return the saved Category object
     */
    public Category addCategory(Category category) {
        category.setId(null);
        category.setName(category.getName() == null ? null : category.getName().trim());

        return categoryRepository.save(category);
    }

    /**
     * Updates an existing category in the repository.
     *
     * @param id the ID of the category to update
     * @param categoryToUpdate the Category object containing the updated data
     * @return the updated Category object if found, or null if not found
     */
    public Category updateCategory(Long id, Category categoryToUpdate) {
        Category categoryFound = categoryRepository.findById(id).orElse(null);

        if (categoryFound == null) {
            return null;
        }

        categoryFound.setName(categoryToUpdate.getName() == null ? null : categoryToUpdate.getName().trim());

        return categoryRepository.save(categoryFound);
    }

    /**
     * Deletes a category by its ID.
     *
     * @param id the ID of the category to delete
     * @return true if the category was deleted, false if the category was not found
     */
    public boolean deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            return false;
        }

        categoryRepository.deleteById(id);
        return true;
    }
}
