/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*POST /books
o GET /books
o GET /books/{id}
o PUT /books/{id}
o DELETE /books/{id}

*/


package com.university.bookstore.bookstoreapi.resources;

import com.university.bookstore.bookstoreapi.model.Book;
import com.university.bookstore.bookstoreapi.store.Storage;
import java.time.LocalDate;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author user
 */
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class BookResource {
    final Storage store=new Storage();
    
    public  Response createBooks(Book book){
            if(
               book.getTitle() == null || 
                book.getAuthor() == null || 
                book.getISBN() == null || 
                book.getPrice() <= 0 || 
                book.getStockQuantity() < 0 || 
                book.getYear() <= 0 ||
                book.getYear()>LocalDate.now().getYear()){
                
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("All fields Must exsist")
                        .build();

                    
               
             }else{
                store.createBookId();
                return Response.status(Response.Status.CREATED).build();
                
            }
    } 
    
    
}
