package org.codewithmagret.rest.report.dto;

import java.util.List;

public class CoursesByStudent {
    private Long studentId;
    private String firstName;
    private String lastName;
    private List<SimpleCourse> courses;

    public CoursesByStudent() {}

    public CoursesByStudent(Long studentId, String firstName, String lastName, List<SimpleCourse> courses) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public List<SimpleCourse> getCourses() { return courses; }
    public void setCourses(List<SimpleCourse> courses) { this.courses = courses; }
}
