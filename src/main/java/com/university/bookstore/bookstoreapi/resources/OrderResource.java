/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bookstore.bookstoreapi.resources;

import com.university.bookstore.bookstoreapi.exception.CustomerNotFoundException;
import com.university.bookstore.bookstoreapi.exception.InvalidInputException;
import com.university.bookstore.bookstoreapi.model.Order;
import com.university.bookstore.bookstoreapi.store.Storage;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author user
 * 
 OrderResource (/customers/{customerId}/orders)
o POST /customers/{customerId}/orders
o GET /customers/{customerId}/orders
o GET /customers/{customerId}/orders/{orderId}
 */

@Path("/customers/{customerId}/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {
    Storage store=new Storage();
    
    
    
    @POST
    public Response addOrders(@PathParam("customerId")String customerId,Order inputOrders){
        Order searchOrder=store.getOrderList().get(customerId);
        if(searchOrder==null){
           throw new CustomerNotFoundException ("Order Relavant to Customer"+customerId+"Not Found");
        }
        
        if(orders.getOrders()==null || orders.getTotal()<=0){
            throw new InvalidInputException ("Must have data for total and orders");
        }
        searchOrder.setTotal(inputOrders.getTotal());
        searchOrder.setItems(inputOrders.getOrders());
        
        store.getOrderList().put(customerId, searchOrder);
        
        return Response.status(Response.Status.CREATED)
                .build();
    }
    
    
    
}
