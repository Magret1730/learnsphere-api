package org.codewithmagret.rest.course;

import org.codewithmagret.rest.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CategoryService categoryService;
}
