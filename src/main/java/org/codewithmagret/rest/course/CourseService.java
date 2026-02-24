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

/**
 * Service class for handling business logic related to Course entities.
 */
@Service
public class CourseService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    /**
     * Default constructor for CourseService.
     */
    public CourseService() {
    }

    /**
     * Retrieves all courses from the repository.
     *
     * @return a list of all courses
     */
    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);

        return  courses;
    }

    /**
     * Retrieves a course by its ID.
     *
     * @param id the ID of the course to retrieve
     * @return the Course object if found, or null if not found
     */
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    /**
     * Adds a new course to the repository.
     *
     * @param req the CourseCreateRequest object containing the data for the new course
     * @return the saved Course object, or null if the category or instructor was not found
     */
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

    /**
     * Updates an existing course in the repository.
     *
     * @param id  the ID of the course to update
     * @param req the CourseCreateRequest object containing the updated data for the course
     * @return the updated Course object if found and updated, or null if the course, category, or instructor was not found
     */
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

    /**
     * Deletes a course by its ID.
     *
     * @param id the ID of the course to delete
     * @return true if the course was deleted, false if the course was not found
     */
    public boolean deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) return false;
        courseRepository.deleteById(id);
        return true;
    }
}
