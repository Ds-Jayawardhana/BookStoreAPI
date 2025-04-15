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
import java.util.UUID;
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
    private final Storage store=new Storage();
    
    public static Response createBooks(Book book){
        if(book.getTitle()==null&&book.getAuthor()==null&&book.getISBN()==null&&book.getYear()==null&&book.getPrice()==null&&book.getStockQuantity()==null){
            String bookId=UUID.randomUUID().toString();
            book.setBookId();
            bookList.put(bookId,book);
        }
        
    } 
    
    
}
