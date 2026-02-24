package org.codewithmagret.rest.category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Category entities, providing CRUD operations.
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}