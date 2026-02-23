package org.codewithmagret.rest.student;

import org.codewithmagret.rest.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {
    @Autowired
    private CategoryRepository categoryRepository;
}
