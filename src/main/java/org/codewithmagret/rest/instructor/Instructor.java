package org.codewithmagret.rest.instructor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.codewithmagret.rest.course.Course;

import java.util.List;

/**
 * Entity class representing an Instructor in the system.
 * An instructor can teach multiple courses, but each course is taught by one instructor.
 */
@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    // One instructor can teach many courses. The Course entity owns this relationship.
    @JsonIgnore
    @OneToMany(mappedBy = "instructor")
    private List<Course> courses;

    /**
     * Default constructor required by JPA.
     * Initializes a new instance of the Instructor class.
     */
    public Instructor() {
    }

    /**
     * Constructs a new Instructor with the specified first name, last name, and email.
     *
     * @param firstName the first name of the instructor
     * @param lastName  the last name of the instructor
     * @param email     the email address of the instructor
     */
    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Gets the unique identifier of the instructor.
     *
     * @return the ID of the instructor
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the instructor.
     *
     * @param id the ID to set for the instructor
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the first name of the instructor.
     *
     * @return the first name of the instructor
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the instructor.
     *
     * @param firstName the first name to set for the instructor
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the instructor.
     *
     * @return the last name of the instructor
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the instructor.
     *
     * @param lastName the last name to set for the instructor
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email address of the instructor.
     *
     * @return the email address of the instructor
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the instructor.
     *
     * @param email the email address to set for the instructor
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the list of courses taught by this instructor.
     *
     * @return the list of courses taught by this instructor
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Sets the list of courses taught by this instructor.
     *
     * @param courses the list of courses to set for this instructor
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
