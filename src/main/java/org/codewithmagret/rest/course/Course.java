package org.codewithmagret.rest.course;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.codewithmagret.rest.category.Category;
import org.codewithmagret.rest.instructor.Instructor;
import org.codewithmagret.rest.student.Student;

import java.util.List;

/**
 * Represents a course that students can enroll in.
 * Each course belongs to one category and is taught by one instructor.
 * A course can have many students enrolled in it.
 *
 * This entity is used to manage the courses offered in the system,
 * allowing students to browse and enroll in courses based on their interests and needs.
 */
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String code;

    // Many courses can belong to ONE category. Foreign key: `category_id`
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // Many courses can be taught by one instructor. Foreign key: `instructor_id`
    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;

    // One student can take many courses, One course can have many students. The Student entity owns this relationship.
    @JsonIgnore // To prevent infinite recursion during JSON serialization // “When converting this object to JSON, skip this field.”
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    /**
     * Default constructor required by JPA.
     * Initializes a new instance of the Course class.
     */
    public Course() {}

    /**
     * Constructs a new Course with the specified title, code, category, and instructor.
     *
     * @param title      the title of the course
     * @param code       the unique code for the course
     * @param category   the category to which the course belongs
     * @param instructor the instructor teaching the course
     */
    public  Course(String title, String code, Category category, Instructor instructor) {
        this.title = title;
        this.code = code;
        this.category = category;
        this.instructor = instructor;
    }

    /**
     * Gets the unique identifier of the course.
     *
     * @return the ID of the course
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the course.
     *
     * @param id the ID to set for the course
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the title of the course.
     *
     * @return the title of the course
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the course.
     *
     * @param title the title to set for the course
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the unique code of the course.
     *
     * @return the code of the course
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the unique code of the course.
     *
     * @param code the code to set for the course
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the category to which the course belongs.
     *
     * @return the category of the course
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets the category to which the course belongs.
     *
     * @param category the category to set for the course
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Gets the instructor teaching the course.
     *
     * @return the instructor of the course
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * Sets the instructor teaching the course.
     *
     * @param instructor the instructor to set for the course
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    /**
     * Gets the list of students enrolled in the course.
     *
     * @return the list of students in the course
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Sets the list of students enrolled in the course.
     *
     * @param students the list of students to set for the course
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
