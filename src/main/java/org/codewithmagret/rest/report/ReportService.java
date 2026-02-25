package org.codewithmagret.rest.report;

import org.codewithmagret.rest.category.Category;
import org.codewithmagret.rest.category.CategoryRepository;
import org.codewithmagret.rest.category.CategoryService;
import org.codewithmagret.rest.course.Course;
import org.codewithmagret.rest.course.CourseRepository;
import org.codewithmagret.rest.report.dto.CoursesByCategory;
import org.codewithmagret.rest.report.dto.SimpleCourse;
import org.codewithmagret.rest.student.Student;
import org.codewithmagret.rest.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for handling business logic related to reports.
 */
@Service
public class ReportService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Retrieves a list of courses grouped by their categories.
     *
     * @return a list of courses grouped by category
     */
    public List<CoursesByCategory> getCoursesPerCategory() {
        List<CoursesByCategory> result = new ArrayList<>();

        Iterable<Category> categories = categoryRepository.findAll();
        for (Category cat : categories) {
            List<SimpleCourse> courseDtos = new ArrayList<>();
            List<Course> courses = cat.getCourses();

            if (courses != null) {
                for (Course c : courses) {
                    courseDtos.add(new SimpleCourse(c.getId(), c.getTitle(), c.getCode()));
                }
            }

            result.add(new CoursesByCategory(cat.getId(), cat.getName(), courseDtos));
        }

        return result;
    }

}
