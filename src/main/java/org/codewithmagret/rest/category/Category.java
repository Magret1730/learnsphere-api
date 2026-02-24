package org.codewithmagret.rest.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.codewithmagret.rest.course.Course;

import java.util.List;

/**
 * Represents a category that courses can belong to.
 * Each category can have multiple courses, but each course belongs to only one category.
 *
 * This entity is used to organize courses into different categories,
 * making it easier for users to find and browse courses based on their interests.
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Course> courses;

    /**
     * Default constructor required by JPA.
     * Initializes a new instance of the Category class.
     */
    public Category() {
    }

    /**
     * Gets the unique identifier of the category.
     *
     * @return the ID of the category
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the category.
     *
     * @param id the ID to set for the category
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the category.
     *
     * @return the name of the category
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the category.
     *
     * @param name the name to set for the category
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the list of courses that belong to this category.
     *
     * @return the list of courses in this category
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Sets the list of courses that belong to this category.
     *
     * @param courses the list of courses to set for this category
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
