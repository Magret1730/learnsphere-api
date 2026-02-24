package org.codewithmagret;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the RESTful service,
 * responsible for bootstrapping the Spring Boot application.
 */
@SpringBootApplication
public class RestServiceApplication {
    /**
     * The entry point of the application, which starts the Spring Boot context.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }
}

