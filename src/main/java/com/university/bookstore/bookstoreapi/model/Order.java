/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bookstore.bookstoreapi.model;

import java.util.Map;

/**
 *
 * @author user
 */
public class Order {

    public Order() {
    }

    public Order(String customersId, Map<Integer, Integer> orders) {
        this.customersId = customersId;
        this.orders = orders;
    }

    public String getCustomersId() {
        return customersId;
    }

    public void setCustomersId(String customersId) {
        this.customersId = customersId;
    }
    
    public Map<Integer, Integer> getOrders() {
        return orders;
    }

    public void setItems(Map<Integer, Integer> orders) {
        this.orders = orders;
    }
    private String customersId;
    private Map<Integer,Integer>orders;
}
