package org.codewithmagret.rest.course;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Course entities, providing CRUD operations.
 */
@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
}