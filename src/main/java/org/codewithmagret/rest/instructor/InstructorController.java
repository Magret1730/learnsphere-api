package org.codewithmagret.rest.instructor;

import org.codewithmagret.rest.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class InstructorController {
    @Autowired
    private CategoryService categoryService;
}
