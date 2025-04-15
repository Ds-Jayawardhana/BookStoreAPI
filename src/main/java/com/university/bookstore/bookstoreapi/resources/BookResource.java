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

import com.university.bookstore.bookstoreapi.exception.BookNotFoundException;
import com.university.bookstore.bookstoreapi.exception.InvalidInputException;
import com.university.bookstore.bookstoreapi.model.Book;
import com.university.bookstore.bookstoreapi.store.Storage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
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
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class BookResource {
    final Storage store=new Storage();
    
    
    @POST
    public  Response createBooks(Book book){
            if(
                book.getTitle() == null || 
                book.getAuthor() == null || 
                book.getISBN() == null || 
                book.getPrice() <= 0 || 
                book.getStockQuantity() < 0 || 
                book.getYear() <= 0 
                ){
                
                throw new InvalidInputException("All fields are required and must be valid.");
            
            }
            if(book.getYear()>LocalDate.now().getYear()){
                throw new InvalidInputException("The publication year must not be in the future");
            
            }
            store.createBookId();
            return Response.status(Response.Status.CREATED).build();
   
    } 
    
    @GET
    public List<Book> getAllBooks(){
        return new ArrayList<>(Storage.getBookList().values());
        
    }
    
    @GET
    @Path("/{id}")
    public Response getBooksById(@PathParam("id") String bookId){
        Book book=Storage.getBookList().get(bookId);
        if(book==null){
            
             throw new BookNotFoundException("Book With the ID"+ bookId +"Was Not Found");
        
        }
        
        return Response.ok()
                .entity(book)
                .build();
                
    }
    @PUT
    @Path("/{id}")
    public Response updateBooksById(@PathParam("id") String bookId,Book updatedBook){
        Book exsistingBook=Storage.getBookList().get(bookId);
        
        if(exsistingBook==null){
             throw new BookNotFoundException("Book With the ID"+ bookId +"Was Not Found");
        
        }
        
        if(exsistingBook.getTitle() != null ){
            exsistingBook.setTitle(updatedBook.getTitle());
        }
         if(exsistingBook.getAuthor() != null ){
            exsistingBook.setAuthor(updatedBook.getAuthor());
        }
          if(exsistingBook.getISBN() != null ){
            exsistingBook.setISBN(updatedBook.getISBN());
        }
           if(exsistingBook.getYear()!= 0 && exsistingBook.getYear()<=LocalDate.now().getYear() ){
            exsistingBook.setYear(updatedBook.getYear());
        }
            if(exsistingBook.getPrice() != 0 && exsistingBook.getPrice()>0 ){
            exsistingBook.setPrice(updatedBook.getPrice());
        }
             if(exsistingBook.getStockQuantity()!= 0 &&exsistingBook.getStockQuantity()<0 ){
            exsistingBook.setStockQuantity(updatedBook.getStockQuantity());
        }
         
        Storage.getBookList().put(bookId, updatedBook);
        
        return Response.status(Response.Status.CREATED)
                .entity(updatedBook)
                .build();
    }

    
}
