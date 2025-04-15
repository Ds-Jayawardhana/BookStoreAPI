/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bookstore.bookstoreapi.resources;

import com.university.bookstore.bookstoreapi.exception.InvalidInputException;
import com.university.bookstore.bookstoreapi.model.Author;
import com.university.bookstore.bookstoreapi.store.Storage;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author user
 */
/*AuthorResource (/authors)
o POST /authors
o GET /authors
o GET /authors/{id}
o PUT /authors/{id}
o DELETE /authors/{id}
o GET /authors/{id}/books*/



@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {
    final Storage store =new Storage();
    
    
    @POST
    public Response createAuthors(Author author){
        if(author.getBiography()==null||author.getName()==null){
            throw new InvalidInputException("Any of fields Not must be empty");
        
        }
        String authorId=store.createAuthorId();
        store.getAuthorList().put(authorId, author);
        return Response.status(Response.Status.CREATED)
                .build();
    }
    
    @GET
    public Author getAllAuthors(){
        
    }
    
    
}
