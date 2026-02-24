package org.codewithmagret.rest.instructor;

import org.codewithmagret.rest.category.CategoryService;
import org.codewithmagret.rest.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @GetMapping()
    public List<Instructor> getAllInstructors() {
        return instructorService.getInstructors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(Long id) {
        Instructor instructor = instructorService.getInstructorById(id);
        if (instructor == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(instructor);
    }

    @PostMapping()
    public ResponseEntity<Instructor> addInstructor(@RequestBody Instructor instructor) {
        Instructor created = instructorService.addInstructor(instructor);
        if (created == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Long id, @RequestBody Instructor instructor) {
        Instructor updated = instructorService.updateInstructor(id, instructor);
        if (updated == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
        boolean deleted = instructorService.deleteInstructor(id);
        if (!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
