package org.codewithmagret.rest.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing courses.
 */
@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * Retrieves a list of all courses.
     *
     * @return A list of Course objects.
     */
    @GetMapping
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    /**
     * Retrieves a course by its ID.
     *
     * @param id The ID of the course to retrieve.
     * @return A ResponseEntity containing the Course object if found, or a 404 Not Found status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        if (course == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(course);
    }

    /**
     * Creates a new course.
     *
     * @param req The CourseCreateRequest object containing the data for the new course.
     * @return A ResponseEntity containing the created Course object, or a 400 Bad Request status if the creation failed.
     */
    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody CourseCreateRequest req) {
        Course created = courseService.addCourse(req);
        if (created == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(created);
    }

    /**
     * Updates an existing course.
     *
     * @param id  The ID of the course to update.
     * @param req The CourseCreateRequest object containing the updated data for the course.
     * @return A ResponseEntity containing the updated Course object if found and updated, or a 400 Bad Request status if the update failed.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody CourseCreateRequest req) {
        Course updated = courseService.updateCourse(id, req);
        if (updated == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(updated);
    }

    /**
     * Deletes a course by its ID.
     *
     * @param id The ID of the course to delete.
     * @return A ResponseEntity with a 204 No Content status if the deletion was successful, or a 404 Not Found status if the course was not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        boolean deleted = courseService.deleteCourse(id);
        if (!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
