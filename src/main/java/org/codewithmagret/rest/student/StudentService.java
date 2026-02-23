package org.codewithmagret.rest.student;

import org.codewithmagret.rest.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private CategoryRepository categoryRepository;
}
