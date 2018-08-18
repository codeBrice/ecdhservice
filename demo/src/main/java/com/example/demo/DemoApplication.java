package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * use auto-configuration, component scan and be able to define extra configuration on their "application class".
 *
 * @since 1.0
 * @author teamJeb
 * @version 1.0
 */
@SpringBootApplication
public class DemoApplication  extends SpringBootServletInitializer {
    /**
    * used to raise the application in local and in test.
    * @param args String[]
    */
    public static void main(final String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }
}
