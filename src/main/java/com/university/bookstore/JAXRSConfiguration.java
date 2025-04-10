package com.university.bookstore;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class JAXRSConfiguration extends ResourceConfig {
    public JAXRSConfiguration() {
        // Scan for resource classes in the resources package
        packages("com.university.bookstore.resources");
    }
}