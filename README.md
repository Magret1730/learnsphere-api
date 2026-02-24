# LearnSphere API

LearnSphere API is a Spring Boot RESTful backend application designed to manage an online course platform.

It provides structured endpoints for managing:

- Categories
- Courses
- Instructors
- Students
- Student Enrollments

This project demonstrates:

- REST API design
- Relational database modeling
- Entity relationships (One-to-Many, Many-to-Many)
- Full CRUD operations
- Proper HTTP response handling
- Swagger documentation support
- Clean layered architecture

---

## Project Overview

The API supports the following business logic:

1. A **Category** has many Courses
2. A **Course** belongs to one Category
3. A **Course** has one Instructor
4. An **Instructor** can teach many Courses
5. A **Student** can enroll in many Courses
6. A **Course** can have many Students

The API is fully testable using Postman or Swagger UI.

---

## Architecture

The application follows a layered structure:

```
learnsphere-api/src/main/java/org.codewithmagret/rest
│
├── category/
│   ├── Category.java
│   ├── CategoryRepository.java
│   ├── CategoryService.java
│   └── CategoryController.java
│
├── course/
│   ├── Course.java
│   ├── CourseRepository.java
│   ├── CourseService.java
│   └── CourseController.java
│
├── instructor/
│   ├── Instructor.java
│   ├── InstructorRepository.java
│   ├── InstructorService.java
│   └── InstructorController.java
│
├── student/
│   ├── Student.java
│   ├── StudentRepository.java
│   ├── StudentService.java
│   └── StudentController.java
│
└── RestServiceApplication.java
```

---

## Entity Relationships

### 1. Category → Course (One-to-Many)

- One category can contain multiple courses.
- Each course belongs to exactly one category.

Database:  
`course.category_id` (Foreign Key)

---

### 2. Instructor → Course (One-to-Many)

- One instructor can teach multiple courses.
- Each course has one instructor.

Database:  
`course.instructor_id` (Foreign Key)

---

### 3. Student ↔ Course (Many-to-Many)

- A student can enroll in multiple courses.
- A course can have multiple students.

Database:
`student_course` (Join Table)

| student_id | course_id |
|------------|------------|

Student entity owns this relationship.

---

## Base URL

```
http://localhost:8080/api/v1
```

---

# API Endpoints

---

## Categories

### GET all categories
```
GET /categories
```

### GET category by ID
```
GET /categories/{id}
```

### POST create category
```
POST /categories
```
```json
{
  "name": "Computer Science"
}
```

### PUT update category
```
PUT /categories/{id}
```

### DELETE category
```
DELETE /categories/{id}
```

---

## Courses

### GET all courses
```
GET /courses
```

### GET course by ID
```
GET /courses/{id}
```

### POST create course
```
POST /courses
```
```json
{
  "title": "Data Structures",
  "code": "CS102",
  "categoryId": 1,
  "instructorId": 1
}
```

### PUT update course
```
PUT /courses/{id}
```

### DELETE course
```
DELETE /courses/{id}
```

---

## Instructors

### GET all instructors
```
GET /instructors
```

### GET instructor by ID
```
GET /instructors/{id}
```

### POST create instructor
```
POST /instructors
```
```json
{
  "firstName": "Jamie",
  "lastName": "Kells",
  "email": "jamie.kells@keyin.ca"
}
```

### PUT update instructor
```
PUT /instructors/{id}
```

### DELETE instructor
```
DELETE /instructors/{id}
```

---

## Students

### GET all students
```
GET /students
```

### GET student by ID
```
GET /students/{id}
```

### POST create student
```
POST /students
```
```json
{
  "firstName": "John",
  "lastName": "Doe"
}
```

### PUT update student
```
PUT /students/{id}
```

### DELETE student
```
DELETE /students/{id}
```

---

## 🎓 Enrollment

### Enroll student in course
```
POST /students/{studentId}/enroll/{courseId}
```

### Remove student from course
```
DELETE /students/{studentId}/unenroll/{courseId}
```

---

# Technologies Used

- Java 25
- Spring Boot 4
- Spring Web (MVC)
- Spring Data JPA
- H2 / MySQL
- Swagger (springdoc-openapi)
- Maven

---

# Database Configuration

Example `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/learnsphere
spring.datasource.username=root
spring.datasource.password=password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# Swagger Documentation

After starting the application:

```
http://localhost:8080/swagger
```

---

# How to Run

### 1. Clone Repository
```
git clone https://github.com/YOUR_USERNAME/learnsphere-api.git
```

### 2. Build
```
mvn clean install
```

### 3. Run

```
run `RestServiceApplication.java` from IntelliJ.
```

---

# Sprint Requirements Covered

- Separate backend repository
- Full CRUD (GET, POST, PUT, DELETE)
- Relational database with foreign keys
- Four core relationships implemented
- Fully testable via Postman
- Swagger documentation
- Clean layered architecture

---

## 📚 API Documentation

Full Javadoc documentation can be found here:

[View Javadoc Documentation](./docs/index.html)

---

# Design Decisions

- Used CrudRepository for simplicity
- Used field injection (@Autowired) for clarity
- Used ResponseEntity for proper HTTP responses
- Used JsonIgnore to prevent recursive JSON serialization

---

# Author

Abiodun Magret Oyedele  
Software Development – Keyin College  
Sprint Week – Winter 2026

---