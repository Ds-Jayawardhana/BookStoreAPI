/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bookstore.bookstoreapi.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */
public class Cart {
    private String customerId;
    private Map<String,Integer>quantity;
    
    
    

    public Cart() {
    }

    public Cart(String customerId, Map<String, Integer> quantity) {
        this.customerId = customerId;
        this.quantity = new HashMap<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Map<String, Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(Map<String, Integer> quantity) {
        this.quantity = quantity;
    }
    
    
  
}
