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

    public Order(int total, Map<Integer, Integer> orders) {
        this.total = total;
        this.orders = orders;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    public Map<Integer, Integer> getOrders() {
        return orders;
    }

    public void setItems(Map<Integer, Integer> orders) {
        this.orders = orders;
    }
    private int total;
    private Map<Integer,Integer>orders;
}
