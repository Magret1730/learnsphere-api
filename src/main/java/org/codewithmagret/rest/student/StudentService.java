package org.codewithmagret.rest.student;

import org.codewithmagret.rest.category.CategoryRepository;
import org.codewithmagret.rest.course.Course;
import org.codewithmagret.rest.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student addStudent(Student student) {
        student.setId(null);
        if (student.getFirstName() != null) student.setFirstName(student.getFirstName().trim());
        if (student.getLastName() != null) student.setLastName(student.getLastName().trim());
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentToUpdate) {
        Student existing = getStudentById(id);
        if (existing == null) return null;

        existing.setFirstName(studentToUpdate.getFirstName() == null ? null : studentToUpdate.getFirstName().trim());
        existing.setLastName(studentToUpdate.getLastName() == null ? null : studentToUpdate.getLastName().trim());

        return studentRepository.save(existing);
    }

    public boolean deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            return false;
        }

        studentRepository.deleteById(id);
        return true;
    }

    // Enroll a student in a course
    public Student enrollStudentInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);

        if (student == null || course == null) return null;

        student.getCourses().add(course);
        return studentRepository.save(student);
    }

    // Unenroll a student from a course
    public Student unenrollStudentFromCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);

        if (student == null || course == null) return null;

        student.getCourses().remove(course);
        return studentRepository.save(student);
    }
}
