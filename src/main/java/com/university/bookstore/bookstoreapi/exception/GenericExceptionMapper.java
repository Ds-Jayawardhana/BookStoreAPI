package com.university.bookstore.bookstoreapi.exception;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */


import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<RuntimeException> {
    @Override
    public Response toResponse(RuntimeException exception) {
        Map<String, String> error = new HashMap<>();
        error.put("error", exception.getClass().getSimpleName());
        error.put("message", exception.getMessage());
        int status;
        if (exception instanceof CustomerNotFoundException ||
            exception instanceof AuthorNotFoundException ||
            exception instanceof BookNotFoundException) {
            status = 404;
        } else if (exception instanceof InvalidInputException) {
            status = 400;
        } else {
            status = 500;
        }
        return Response.status(status)
                      .entity(error)
                      .type(MediaType.APPLICATION_JSON)
                      .build();
    }
}