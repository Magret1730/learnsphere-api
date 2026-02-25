package org.codewithmagret.rest.report.dto;

public class SimpleCourse {
    private Long courseId;
    private String title;
    private String code;

    public SimpleCourse() {}

    public SimpleCourse(Long courseId, String title, String code) {
        this.courseId = courseId;
        this.title = title;
        this.code = code;
    }

    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}
