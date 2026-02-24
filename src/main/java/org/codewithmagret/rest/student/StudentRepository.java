package org.codewithmagret.rest.student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Student entities, providing CRUD operations.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
