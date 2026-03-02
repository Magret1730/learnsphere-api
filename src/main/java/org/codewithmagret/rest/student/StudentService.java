package org.codewithmagret.rest.student;

import org.codewithmagret.rest.course.Course;
import org.codewithmagret.rest.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for handling business logic related to Student entities.
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    /**
     * Default constructor for StudentService.
     */
    public StudentService() {
    }

    /**
     * Retrieves all students from the repository.
     *
     * @return a list of all students
     */
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    /**
     * Retrieves a student by its ID.
     *
     * @param id the ID of the student to retrieve
     * @return the Student object if found, or null if not found
     */
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    /**
     * Adds a new student to the repository.
     *
     * @param student the Student object to add
     * @return the saved Student object
     */
    public Student addStudent(Student student) {
        student.setId(null);
        if (student.getFirstName() != null) student.setFirstName(student.getFirstName().trim());
        if (student.getLastName() != null) student.setLastName(student.getLastName().trim());

        if (studentRepository.existsByFirstNameIgnoreCaseAndLastNameIgnoreCase(
                student.getFirstName(), student.getLastName())) {
            throw new IllegalArgumentException("Student with this first and last name already exists.");
        }

        return studentRepository.save(student);
    }

    /**
     * Updates an existing student in the repository.
     *
     * @param id              the ID of the student to update
     * @param studentToUpdate the Student object containing the updated data
     * @return the updated Student object if found, or null if not found
     */
    public Student updateStudent(Long id, Student studentToUpdate) {
        Student existing = getStudentById(id);

        // If the student with the given ID does not exist, return null
        if (existing == null) {
            throw new IllegalArgumentException("Student not found.");
        };

        existing.setFirstName(studentToUpdate.getFirstName() == null ? null : studentToUpdate.getFirstName().trim());
        existing.setLastName(studentToUpdate.getLastName() == null ? null : studentToUpdate.getLastName().trim());

        return studentRepository.save(existing);
    }

    /**
     * Deletes a student by its ID.
     *
     * @param id the ID of the student to delete
     * @return true if the student was deleted, false if the student was not found
     */
    public boolean deleteStudent(Long id) {
        // Check if the student exists before attempting to delete
        if (!studentRepository.existsById(id)) {
            return false;
        }

        studentRepository.deleteById(id);
        return true;
    }

    /**
     * Enrolls a student in a course.
     *
     * @param studentId the ID of the student to enroll
     * @param courseId  the ID of the course to enroll the student in
     * @return the updated Student object if both the student and course
     *          were found and enrollment was successful, or null if either was not found
     */
    public Student enrollStudentInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);

        // If either the student or course is not found, return null
        if (student == null || course == null) {
            throw new IllegalArgumentException("Student or course not found.");
        };

        // Check if the student is already enrolled in the course
        boolean already = student.getCourses().stream()
                .anyMatch(c -> c.getId().equals(courseId));
        if (already) return student;

        student.getCourses().add(course);
        return studentRepository.save(student);
    }

    /**
     * Unenrolls a student from a course.
     *
     * @param studentId the ID of the student to unenroll
     * @param courseId  the ID of the course to unenroll the student from
     *
     * @return the updated Student object if both the student and course
     *          were found and unenrollment was successful, or null if either was not found
     */
    public Student unenrollStudentFromCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);

        if (student == null || course == null) {;
            throw new IllegalArgumentException("Student or course not found.");
        };

        student.getCourses().remove(course);
        return studentRepository.save(student);
    }
}
