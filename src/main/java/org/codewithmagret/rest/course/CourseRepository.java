package org.codewithmagret.rest.course;

import org.codewithmagret.rest.category.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Category,Long> {
}
