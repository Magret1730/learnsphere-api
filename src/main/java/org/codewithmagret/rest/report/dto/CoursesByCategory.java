package org.codewithmagret.rest.report.dto;

import org.codewithmagret.rest.course.Course;

import java.util.List;

/**
 * This class represents a report of courses grouped by category.
 * It contains the category name and the number of courses in that category.
 * It is used as a Data Transfer Object (DTO) to transfer data from the service layer
 */
public class CoursesByCategory {
    private Long categoryId;
    private String categoryName;
    private List<SimpleCourse> courses;

    public CoursesByCategory() {}

    public CoursesByCategory(Long categoryId, String categoryName, List<SimpleCourse> courses) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.courses = courses;
    }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public List<SimpleCourse> getCourses() { return courses; }
    public void setCourses(List<SimpleCourse> courses) { this.courses = courses; }
}
