/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bookstore.bookstoreapi.resources;

import com.university.bookstore.bookstoreapi.exception.CustomerNotFoundException;
import com.university.bookstore.bookstoreapi.model.Cart;
import com.university.bookstore.bookstoreapi.model.Customer;
import com.university.bookstore.bookstoreapi.store.Storage;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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


@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartResource {
    Storage store=new Storage();
    
    
    @POST
    @Path("/{id}/cart")
    public Response getAllItems(@PathParam("id") String customerId,Cart incomingCart){
        Customer searchCart=store.getCustomerList().get(customerId);
        
        if(searchCart==null){
            throw new CustomerNotFoundException("Cart associated with customer cannot find"+customerId);
        }
        
        Cart exsistingCart=store.getCartList().get(customerId);
        
        if(exsistingCart==null){
                Cart cart=new Cart(customerId);
                cart.setQuantity(incomingCart.getQuantity());
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
         return searchCart;
    }
}
