package org.codewithmagret.rest.course;

import jakarta.persistence.*;
import org.codewithmagret.rest.category.Category;
import org.codewithmagret.rest.instructor.Instructor;
import org.codewithmagret.rest.student.Student;

import java.util.List;

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
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public Course() {}

    public  Course(String title, String code, Category category, Instructor instructor) {
        this.title = title;
        this.code = code;
        this.category = category;
        this.instructor = instructor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
