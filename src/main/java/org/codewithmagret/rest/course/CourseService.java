package org.codewithmagret.rest.course;

import org.codewithmagret.rest.category.Category;
import org.codewithmagret.rest.category.CategoryRepository;
import org.codewithmagret.rest.category.CategoryService;
import org.codewithmagret.rest.instructor.Instructor;
import org.codewithmagret.rest.instructor.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    public List<Category> getCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);

        return  courses;
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course addCourse(CourseCreateRequest req) {
        Category category = categoryRepository.findById(req.getCategoryId()).orElse(null);
        Instructor instructor = instructorRepository.findById(req.getInstructorId()).orElse(null);

        System.out.println("Category found: " + category);
        System.out.println("Instructor found: " + instructor);

        if (category == null || instructor == null) {
            return null;
        }

        Course c = new Course();
        c.setTitle(req.getTitle() == null ? null : req.getTitle().trim());
        c.setCode(req.getCode() == null ? null : req.getCode().trim());
        c.setCategory(category);
        c.setInstructor(instructor);

        return courseRepository.save(c);
    }

    public Course updateCourse(Long id, CourseCreateRequest req) {
        Course existing = getCourseById(id);
        if (existing == null) return null;

        Category category = categoryRepository.findById(req.getCategoryId()).orElse(null);
        Instructor instructor = instructorRepository.findById(req.getInstructorId()).orElse(null);

        if (category == null || instructor == null) {
            return null; // controller will return 400
        }

        existing.setTitle(req.getTitle() == null ? null : req.getTitle().trim());
        existing.setCode(req.getCode() == null ? null : req.getCode().trim());
        existing.setCategory(category);
        existing.setInstructor(instructor);

        return courseRepository.save(existing);
    }

    public boolean deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) return false;
        courseRepository.deleteById(id);
        return true;
    }
}
