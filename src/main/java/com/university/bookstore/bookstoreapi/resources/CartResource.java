/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bookstore.bookstoreapi.resources;

import com.university.bookstore.bookstoreapi.exception.BookNotFoundException;
import com.university.bookstore.bookstoreapi.exception.CustomerNotFoundException;
import com.university.bookstore.bookstoreapi.exception.InvalidInputException;
import com.university.bookstore.bookstoreapi.model.Book;
import com.university.bookstore.bookstoreapi.model.Cart;
import com.university.bookstore.bookstoreapi.model.Customer;
import com.university.bookstore.bookstoreapi.store.Storage;
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
o CartResource (/customers/{customerId}/cart)
o POST /customers/{customerId}/cart/items
o GET /customers/{customerId}/cart
o PUT /customers/{customerId}/cart/items/{bookId}
o DELETE /customers/{customerId}/cart/items/{bookId}
 */


@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartResource {
    Storage store=new Storage();
    
    
    @POST
    @Path("/{id}/cart/items")
    public Response getAllItems(@PathParam("id") String customerId,Cart incomingCart){
        Customer searchCart=store.getCustomerList().get(customerId);
        
        if(searchCart==null){
            throw new CustomerNotFoundException("Customer with ID " + customerId + " not found.");
        }
        
        Cart exsistingCart=store.getCartList().get(customerId);
        
        if(exsistingCart==null){
                Cart cart=new Cart(customerId);
                cart.setItems(incomingCart.getItems());
                store.getCartList().put(customerId, cart);
        
        }
        store.getCartList().put(customerId, exsistingCart);
        return Response.status(Response.Status.CREATED)
                .build();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        
        
    }
    @GET
    @Path("{id}/cart")
    public Cart getCart(@PathParam("id") String customerId){
         Cart searchCart=store.getCartList().get(customerId);
          if(searchCart==null){
              throw new CustomerNotFoundException("Cart for customer with ID " + customerId + " not found.");
          }
         return searchCart;
    }
    
    
    
//    @PUT
//    @Path("{id}/cart/items/{bookId}")
//    public Response updateCartItems(
//            
//            @PathParam("id")String customerId,
//            @PathParam("bookId")String bookId,Cart inputCart){
//        Cart searchCart=store.getCartList().get(customerId);
//        
//        if(searchCart==null){
//            throw new CustomerNotFoundException("Cart relvant to this id Not Found");
//        }
//        
//        if(inputCart==null){
//            throw new InvalidInputException("Cart items must not be null.");
//        }
//        if(searchCart.getItems().containsKey(bookId)){
//            searchCart.setItems(inputCart.getItems());
//            store.getCartList().put(customerId, searchCart);
//        }
//        else{
//            throw new BookNotFoundException("Book with ID " + bookId + " not found in cart.");
//        }
//        
//        return Response.status(Response.Status.CREATED)
//                .build();
//    }
    
@PUT
@Path("{id}/cart/items/{bookId}")
public Response updateCartItems(
        @PathParam("id") String customerId,
        @PathParam("bookId") String bookId,
        Cart inputCart) {

    if (!store.getCustomerList().containsKey(customerId)) {
        throw new CustomerNotFoundException("Customer with ID " + customerId + " was not found");
    }


    Book book = store.getBookList().get(bookId);
    if (book == null) {
        throw new BookNotFoundException("Book with ID " + bookId + " was not found");
    }


    if (inputCart == null || inputCart.getItems() == null || !inputCart.getItems().containsKey(bookId)) {
        throw new InvalidInputException("Cart items must include the book ID " + bookId + " with a valid quantity");
    }


    Cart searchCart = store.getCartList().get(customerId);
    if (searchCart == null) {
        searchCart = new Cart();
        store.getCartList().put(customerId, searchCart);
    }


    Integer quantity = inputCart.getItems().get(bookId);
    if (quantity == null || quantity <= 0) {
        throw new InvalidInputException("Quantity for book ID " + bookId + " must be greater than 0");
    }


    searchCart.getItems().put(bookId, quantity);
    store.getCartList().put(customerId, searchCart);

    return Response.ok(searchCart).build();
}
    
    
    @DELETE
    @Path("{id}/cart/items/{bookId}")
    public Response deleteCartItems(
            @PathParam("id")String customerId,
            @PathParam("bookId")String bookId){
        Cart searchCart=store.getCartList().get(customerId);
        
         if(searchCart==null){
            throw new CustomerNotFoundException("Cart for customer with ID " + customerId + " not found.");
        }
         if(searchCart.getItems().containsKey(bookId)){
             searchCart.getItems().remove(bookId);
         }
         
         return Response.noContent().build();
    }
}
    
