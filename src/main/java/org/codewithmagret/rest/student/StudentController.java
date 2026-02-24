package org.codewithmagret.rest.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing students and their course enrollments.
 */
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * Retrieves a list of all students.
     *
     * @return A list of Student objects.
     */
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    /**
     * Retrieves a student by its ID.
     *
     * @param id The ID of the student to retrieve.
     * @return A ResponseEntity containing the Student object if found, or a 404 Not Found status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if (student == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(student);
    }

    /**
     * Creates a new student.
     *
     * @param student The Student object to create.
     * @return A ResponseEntity containing the created Student object.
     */
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    /**
     * Updates an existing student.
     *
     * @param id      The ID of the student to update.
     * @param updated The Student object containing the updated data.
     * @return A ResponseEntity containing the updated Student object if found, or a 404 Not Found status if not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updated) {
        Student saved = studentService.updateStudent(id, updated);
        if (saved == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(saved);
    }

    /**
     * Deletes a student by its ID.
     *
     * @param id The ID of the student to delete.
     * @return A ResponseEntity with a 204 No Content status if the deletion was successful, or a 404 Not Found status if the student was not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        boolean deleted = studentService.deleteStudent(id);
        if (!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    /**
     * Enrolls a student in a course.
     *
     * @param studentId The ID of the student to enroll.
     * @param courseId  The ID of the course to enroll the student in.
     * @return A ResponseEntity containing the updated Student object if the enrollment was successful,
     *          or a 400 Bad Request status if the enrollment failed.
     */
    @PostMapping("/{studentId}/enroll/{courseId}")
    public ResponseEntity<Student> enrollStudent(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {

        Student updated = studentService.enrollStudentInCourse(studentId, courseId);
        if (updated == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(updated);
    }

    /**
     * Unenrolls a student from a course.
     *
     * @param studentId The ID of the student to unenroll.
     * @param courseId  The ID of the course to unenroll the student from.
     * @return A ResponseEntity containing the updated Student object if the unenrollment was successful,
     *          or a 400 Bad Request status if the unenrollment failed.
     */
    @DeleteMapping("/{studentId}/unenroll/{courseId}")
    public ResponseEntity<Student> removeEnrollment(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {

        Student updated = studentService.unenrollStudentFromCourse(studentId, courseId);
        if (updated == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(updated);
    }

}
