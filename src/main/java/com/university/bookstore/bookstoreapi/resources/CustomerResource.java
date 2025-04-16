/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bookstore.bookstoreapi.resources;

import com.university.bookstore.bookstoreapi.exception.CustomerNotFoundException;
import com.university.bookstore.bookstoreapi.exception.InvalidInputException;
import com.university.bookstore.bookstoreapi.model.Customer;
import com.university.bookstore.bookstoreapi.store.Storage;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author user
o POST /customers
o GET /customers
o GET /customers/{id}
o PUT /customers/{id}
o DELETE /customers/{id}

 */

@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
    final Storage store=new Storage();
    
    public Response createCustomers(Customer customer){
        if(customer.getEmail()==null||customer.getName()==null|| customer.getPassword()==null){
            throw new InvalidInputException ("All the fields must not be empty");
                
        }
        store.createNewCustomer(customer);
        return Response.status(Response.Status.CREATED)
                .build();
        
        
    }
    
    public List<Customer> getAllCustomer(Customer customer){
        return new ArrayList<>(store.getCustomerList().values());
        
    }
    public Response getCustomerById(@PathParam("id")String customerId){
        Customer customer=store.getCustomerList().get(customerId);
        
        if(customer==null){
            throw new CustomerNotFoundException("Customer with ID"+customerId+"Not Found");
        }
        return Response.ok()
                .entity(customer)
                .build();
    }
    
}
