package org.codewithmagret.rest.course;

/**
 * Data Transfer Object for creating a new Course.
 */
public class CourseCreateRequest {
    private String title;
    private String code;
    private Long categoryId;
    private Long instructorId;

    /**
     * Default constructor for CourseCreateRequest.
     */
    public CourseCreateRequest() {
    }

    /**
     * Gets the title of the course to be created.
     *
     * @return the title of the course
     */
    public String getTitle() { return title; }

    /**
     * Sets the title of the course to be created.
     *
     * @param title the title to set for the course
     */
    public void setTitle(String title) { this.title = title; }

    /**
     * Gets the unique code of the course to be created.
     *
     * @return the code of the course
     */
    public String getCode() { return code; }

    /**
     * Sets the unique code of the course to be created.
     *
     * @param code the code to set for the course
     */
    public void setCode(String code) { this.code = code; }

    /**
     * Gets the ID of the category to which the course belongs.
     *
     * @return the category ID of the course
     */
    public Long getCategoryId() { return categoryId; }

    /**
     * Sets the ID of the category to which the course belongs.
     *
     * @param categoryId the category ID to set for the course
     */
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    /**
     * Gets the ID of the instructor teaching the course.
     *
     * @return the instructor ID of the course
     */
    public Long getInstructorId() { return instructorId; }

    /**
     * Sets the ID of the instructor teaching the course.
     *
     * @param instructorId the instructor ID to set for the course
     */
    public void setInstructorId(Long instructorId) { this.instructorId = instructorId; }
}
