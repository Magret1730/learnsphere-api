package org.codewithmagret.rest.instructor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Instructor entities, providing CRUD operations.
 */
@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Long> {
}
