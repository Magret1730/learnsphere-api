package org.codewithmagret.rest.category;

import jakarta.persistence.*;
import org.codewithmagret.rest.course.Course;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // One category can have many courses. The Course entity owns this relationship.
    @OneToMany(mappedBy = "category")
    private List<Course> courses;

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
