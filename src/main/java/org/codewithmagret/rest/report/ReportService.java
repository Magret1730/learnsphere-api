package org.codewithmagret.rest.report;

import org.codewithmagret.rest.category.Category;
import org.codewithmagret.rest.category.CategoryRepository;
import org.codewithmagret.rest.category.CategoryService;
import org.codewithmagret.rest.course.Course;
import org.codewithmagret.rest.course.CourseRepository;
import org.codewithmagret.rest.instructor.Instructor;
import org.codewithmagret.rest.report.dto.*;
import org.codewithmagret.rest.student.Student;
import org.codewithmagret.rest.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
     * Question 1: What courses are offered in each category?
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

    /**
     * Retrieves a list of courses grouped by students.
     * Question 2: What courses has each student enrolled in?
     *
     * @return a list of courses grouped by student
     */
    public List<CoursesByStudent> getCoursesPerStudent() {
        List<CoursesByStudent> result = new ArrayList<>();

        Iterable<Student> students = studentRepository.findAll();
        for  (Student student : students) {
            List<SimpleCourse> courseDtos = new ArrayList<>();
            List<Course> courses = student.getCourses();

            if (courses != null) {
                for (Course c : courses) {
                    courseDtos.add(new SimpleCourse(c.getId(), c.getTitle(), c.getCode()));
                }
            }

            result.add(new CoursesByStudent(student.getId(), student.getFirstName(), student.getLastName(), courseDtos));
        }

        return result;
    }

    /**
     * Retrieves courses along with their assigned instructors.
     * Question 3: What instructor teaches each course?
     *
     * @return a list of courses with their instructors
     */
    public List<InstructorByCourse> getInstructorPerCourse() {
        List<InstructorByCourse> result = new ArrayList<>();

        Iterable<Course> courses = courseRepository.findAll();
        for (Course course : courses) {
            SimpleInstructor instructorDto = null;
            Instructor instructor = course.getInstructor();

            if (instructor != null) {
                instructorDto = new SimpleInstructor(instructor.getId(), instructor.getFirstName(), instructor.getLastName(), instructor.getEmail());
            }

            result.add(new InstructorByCourse(course.getId(), course.getTitle(), course.getCode(), instructorDto));
        }

        return result;
    }

    /**
     * Retrieves a list of instructors associated with each student.
     * Question 4: What instructors has each student learned from?
     *
     * @return a list of students with their associated instructors
     */
    public List<InstructorsByStudent> instructorsByStudent() {
        List<InstructorsByStudent> result = new ArrayList<>();

        Iterable<Student> students = studentRepository.findAll();
        for (Student s : students) {
            Map<Long, SimpleInstructor> unique = new LinkedHashMap<>();

            List<Course> courses = s.getCourses();
            if (courses != null) {
                for (Course c : courses) {
                    Instructor i = c.getInstructor();
                    if (i != null && i.getId() != null) {
                        unique.putIfAbsent(
                                i.getId(),
                                new SimpleInstructor(i.getId(), i.getFirstName(), i.getLastName(), i.getEmail())
                        );
                    }
                }
            }

            result.add(new InstructorsByStudent(
                    s.getId(),
                    s.getFirstName(),
                    s.getLastName(),
                    new ArrayList<>(unique.values())
            ));
        }

        return result;
    }
}
