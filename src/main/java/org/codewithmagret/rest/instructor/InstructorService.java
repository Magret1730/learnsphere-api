package org.codewithmagret.rest.instructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for handling business logic related to instructors.
 */
@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    /**
     * Default constructor for InstructorService.
     */
    public InstructorService() {
    }

    /**
     * Retrieves all instructors from the repository.
     *
     * @return a list of all instructors
     */
    public List<Instructor> getInstructors() {
        List<Instructor> instructors = new ArrayList<>();
        instructorRepository.findAll().forEach(instructors::add);

        return instructors;
    }

    /**
     * Retrieves an instructor by its ID.
     *
     * @param id the ID of the instructor to retrieve
     * @return the Instructor object if found, or null if not found
     */
    public Instructor getInstructorById(Long id) {
        Instructor instructor = instructorRepository.findById(id).orElse(null);

        System.out.println("instructor = " + instructor);

        return instructor;
    }

    /**
     * Adds a new instructor to the repository.
     *
     * @param instructor the Instructor object to add
     * @return the saved Instructor object
     */
    public Instructor addInstructor(Instructor instructor) {
        instructor.setId(null);
        if (instructor.getFirstName() != null) instructor.setFirstName(instructor.getFirstName().trim());
        if (instructor.getLastName() != null) instructor.setLastName(instructor.getLastName().trim());
        if (instructor.getEmail() != null) instructor.setEmail(instructor.getEmail().trim());
        return instructorRepository.save(instructor);
    }

    /**
     * Updates an existing instructor in the repository.
     *
     * @param id                 the ID of the instructor to update
     * @param instructorToUpdate the Instructor object containing the updated data
     * @return the updated Instructor object if found, or null if not found
     */
    public Instructor updateInstructor(Long id, Instructor instructorToUpdate) {
        Instructor existing = getInstructorById(id);
        if (existing == null) return null;

        existing.setFirstName(instructorToUpdate.getFirstName() == null ? null : instructorToUpdate.getFirstName().trim());
        existing.setLastName(instructorToUpdate.getLastName() == null ? null : instructorToUpdate.getLastName().trim());
        existing.setEmail(instructorToUpdate.getEmail() == null ? null : instructorToUpdate.getEmail().trim());

        return instructorRepository.save(existing);
    }

    /**
     * Deletes an instructor by its ID.
     *
     * @param id the ID of the instructor to delete
     * @return true if the instructor was deleted, or false if the instructor was not found
     */
    public boolean deleteInstructor(Long id) {
        if (!instructorRepository.existsById(id)) {
            return false;
        }

        instructorRepository.deleteById(id);
        return true;
    }
}
