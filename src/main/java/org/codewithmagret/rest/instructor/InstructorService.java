package org.codewithmagret.rest.instructor;

import org.codewithmagret.rest.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> getInstructors() {
        List<Instructor> instructors = new ArrayList<>();
        instructorRepository.findAll().forEach(instructors::add);

        return instructors;
    }

    public Instructor getInstructorById(Long id) {
        return instructorRepository.findById(id).orElse(null);
    }

    public Instructor addInstructor(Instructor instructor) {
        instructor.setId(null);
        if (instructor.getFirstName() != null) instructor.setFirstName(instructor.getFirstName().trim());
        if (instructor.getLastName() != null) instructor.setLastName(instructor.getLastName().trim());
        if (instructor.getEmail() != null) instructor.setEmail(instructor.getEmail().trim());
        return instructorRepository.save(instructor);
    }

    public Instructor updateInstructor(Long id, Instructor instructorToUpdate) {
        Instructor existing = getInstructorById(id);
        if (existing == null) return null;

        existing.setFirstName(instructorToUpdate.getFirstName() == null ? null : instructorToUpdate.getFirstName().trim());
        existing.setLastName(instructorToUpdate.getLastName() == null ? null : instructorToUpdate.getLastName().trim());
        existing.setEmail(instructorToUpdate.getEmail() == null ? null : instructorToUpdate.getEmail().trim());

        return instructorRepository.save(existing);
    }

    public boolean deleteInstructor(Long id) {
        if (!instructorRepository.existsById(id)) {
            return false;
        }

        instructorRepository.deleteById(id);
        return true;
    }
}
