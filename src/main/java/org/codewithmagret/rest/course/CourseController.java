package org.codewithmagret.rest.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;
}
