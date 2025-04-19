/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bookstore.bookstoreapi.resources;

import com.university.bookstore.bookstoreapi.exception.CustomerNotFoundException;
import com.university.bookstore.bookstoreapi.exception.InvalidInputException;
import com.university.bookstore.bookstoreapi.model.Customer;
import com.university.bookstore.bookstoreapi.model.Order;
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
        
        
       Order newOrder= new Order();
    
      Customer searchCustomer=store.getCustomerList().get(customerId);
        if(searchCustomer==null){
           throw new CustomerNotFoundException ("Order Relavant to Customer"+customerId+"Not Found");
        }
        
        if(inputOrders.getOrder()==null ){
            throw new InvalidInputException ("order Fields noort be Null");
        }
//      
        newOrder.setOrderId(store.createOrderId());
        newOrder.setOrder(inputOrders.getOrder());
        
        store.getOrderList().put(customerId, newOrder);
        
        
        return Response.status(Response.Status.CREATED)
                .build();
    }
    @GET
    public List<Object> getOrders(@PathParam("customerId")String customerId){
        Customer searchCustomer=store.getCustomerList().get(customerId);
         Order searchOrder=store.getOrderList().get(customerId);
          if(searchCustomer==null){
           throw new CustomerNotFoundException ("Order Relavant to Customer"+customerId+"Not Found");
        }
          
          return new ArrayList<>(searchOrder.getOrder().entrySet());
        
    }
    
   @GET
   @Path("{orderId}")
   public Response getOrdersByOrderId(
           
           @PathParam("customerId")String customerId,
           @PathParam("orderId")String ordersId){
       
      Order searchOrder=store.getOrderList().get(customerId);
        if (searchOrder.getOrder().containsKey(ordersId)) {
        return Response.ok(searchOrder.getOrder().get(ordersId)).build();
    }
       return Response.status(Response.Status.NOT_FOUND)
            .entity("Order ID " + ordersId + " not found for customer " + customerId)
            .build();
   }
}
    
    
    
   

