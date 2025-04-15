/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bookstore.bookstoreapi.resources;

import com.university.bookstore.bookstoreapi.exception.AuthorNotFoundException;
import com.university.bookstore.bookstoreapi.exception.InvalidInputException;
import com.university.bookstore.bookstoreapi.model.Author;
import com.university.bookstore.bookstoreapi.store.Storage;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    final Storage store=new Storage();
    
    
    @POST
    public Response createAuthors(Author author){
        if(author.getBiography()==null||author.getName()==null){
            throw new InvalidInputException("Any of fields Not must be empty");
        
        }
        store.createNewAuthor(author);
        return Response.status(Response.Status.CREATED)
                .build();
    }
    
    @GET
    public List<Author> getAllAuthors(){
            return new  ArrayList<>(store.getAuthorList().values());
        }
    
    @GET
    @Path("{id}")
    public Author getAuthorsById(@PathParam("id") String authorId){
        Author author=store.getAuthorList().get(authorId);
        if(author==null){
            throw new AuthorNotFoundException("Cannot Find Author With Id"+authorId);
        }
        
        return author;
    }
    
    @PUT
    @Path("{id}")
    public Response updateAuthor(@PathParam("id") String authorId ,Author newAuthor){
        Author author=store.getAuthorList().get(authorId);
        
        
        if(author==null){
            throw new AuthorNotFoundException("Cannot Find Author With Id"+authorId);
        }
        
        if(newAuthor.getBiography()==null || newAuthor.getName()==null){
            throw new InvalidInputException("Field not must be null");
        }
        if(newAuthor.getBiography()!=null){
            author.setBiography(newAuthor.getBiography());
        }
        if(author.getName()!=null ){
            author.setName(newAuthor.getName());
        }
        return Response.status(Response.Status.CREATED)
                .entity("New data Updated"+ author)
                .build();
       
    }
    @DELETE
    @Path("{id}")
    public Response removeAuthor(@PathParam("id") String authorId){
        Author searchAuthor=store.getAuthorList().get(authorId);
        
        if(searchAuthor==null){
           throw new AuthorNotFoundException("Author with Id"+authorId+"cannot find");
        }
        
        store.getAuthorList().remove(authorId);
        return Response.noContent().build();
    }
    
    
    
        
}
    
    

