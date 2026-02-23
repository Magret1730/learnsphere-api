package org.codewithmagret.rest.instructor;

import org.codewithmagret.rest.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends CrudRepository<Category,Long> {
}
