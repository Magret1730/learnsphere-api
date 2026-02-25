package org.codewithmagret.rest.report;

import org.codewithmagret.rest.course.CourseService;
import org.codewithmagret.rest.report.dto.CoursesByCategory;
import org.codewithmagret.rest.report.dto.CoursesByStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/coursesByCategories")
    public List<CoursesByCategory> getCoursesPerCategory() {
        return reportService.getCoursesPerCategory();
    }

    @GetMapping("/coursesByStudents")
    public List<CoursesByStudent> getCoursesPerStudent() {
        return reportService.getCoursesPerStudent();
    }
}
