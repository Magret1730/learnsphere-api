package org.codewithmagret.rest.instructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing instructors.
 */
@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    /**
     * Retrieves a list of all instructors.
     *
     * @return A list of Instructor objects.
     */
    @GetMapping()
    public List<Instructor> getAllInstructors() {
        return instructorService.getInstructors();
    }

    /**
     * Retrieves an instructor by its ID.
     *
     * @param id The ID of the instructor to retrieve.
     * @return A ResponseEntity containing the Instructor object if found, or a 404 Not Found status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Long id) {
        Instructor instructor = instructorService.getInstructorById(id);
        System.out.println("instructor = " + instructor);
        if (instructor == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(instructor);
    }

    /**
     * Creates a new instructor.
     *
     * @param instructor The Instructor object to create.
     * @return A ResponseEntity containing the created Instructor object, or a 400 Bad Request status if the creation failed.
     */
    @PostMapping()
    public ResponseEntity<Instructor> addInstructor(@RequestBody Instructor instructor) {
        Instructor created = instructorService.addInstructor(instructor);
        if (created == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(created);
    }

    /**
     * Updates an existing instructor.
     *
     * @param id         The ID of the instructor to update.
     * @param instructor The Instructor object containing the updated data.
     * @return A ResponseEntity containing the updated Instructor object if found, or a 400 Bad Request status if the update failed.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Long id, @RequestBody Instructor instructor) {
        Instructor updated = instructorService.updateInstructor(id, instructor);
        if (updated == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(updated);
    }

    /**
     * Deletes an instructor by its ID.
     *
     * @param id The ID of the instructor to delete.
     * @return A ResponseEntity with a 204 No Content status if the deletion was successful, or a 404 Not Found status if the instructor was not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
        boolean deleted = instructorService.deleteInstructor(id);
        if (!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
