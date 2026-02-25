package org.codewithmagret.rest.report;

import org.codewithmagret.rest.course.CourseService;
import org.codewithmagret.rest.report.dto.CoursesByCategory;
import org.codewithmagret.rest.report.dto.CoursesByStudent;
import org.codewithmagret.rest.report.dto.InstructorByCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class for handling HTTP requests related to reports.
 */
@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @Autowired
    private CourseService courseService;

    /**
     * Endpoint to retrieve courses grouped by their categories.
     *
     * @return a list of courses grouped by category
     */
    @GetMapping("/coursesByCategories")
    public List<CoursesByCategory> getCoursesPerCategory() {
        return reportService.getCoursesPerCategory();
    }

    /**
     * Endpoint to retrieve courses grouped by students.
     *
     * @return a list of courses grouped by students
     */
    @GetMapping("/coursesByStudents")
    public List<CoursesByStudent> getCoursesPerStudent() {
        return reportService.getCoursesPerStudent();
    }

    /**
     * Endpoint to retrieve instructors by courses.
     *
     * @return the total number of courses
     */
    @GetMapping("/instructorsByCourses")
    public List<InstructorByCourse> getInstructorsByCourses() {
        return reportService.getInstructorPerCourse();
    }
}
