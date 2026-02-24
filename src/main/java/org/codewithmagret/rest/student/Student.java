package org.codewithmagret.rest.student;

import jakarta.persistence.*;
import org.codewithmagret.rest.course.Course;

import java.util.List;

/**
 * Represents a student entity in the system.
 * This class is mapped to a database table using JPA annotations.
 */
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    /**
     * Many-to-many relationship between Student and Course.
     * A student can enroll in multiple courses, and a course can have multiple students.
     * The relationship is managed through a join table named "student_course".
     */
    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )

    private List<Course> courses;

    /**
     * Default constructor required by JPA.
     * Initializes a new instance of the Student class.
     */
    public Student() {}

    /**
     * Constructs a new Student with the specified first name and last name.
     *
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     */
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Gets the unique identifier of the student.
     *
     * @return the ID of the student
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the student.
     *
     * @param id the ID to set for the student
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the first name of the student.
     *
     * @return the first name of the student
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the student.
     *
     * @param firstName the first name to set for the student
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the student.
     *
     * @return the last name of the student
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the student.
     *
     * @param lastName the last name to set for the student
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the list of courses the student is enrolled in.
     *
     * @return a list of courses the student is enrolled in
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Sets the list of courses the student is enrolled in.
     *
     * @param courses a list of courses to set for the student
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
