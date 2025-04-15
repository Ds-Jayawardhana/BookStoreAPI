/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bookstore.bookstoreapi.store;

import com.university.bookstore.bookstoreapi.model.Author;
import com.university.bookstore.bookstoreapi.model.Book;
import com.university.bookstore.bookstoreapi.model.Cart;
import com.university.bookstore.bookstoreapi.model.Customer;
import com.university.bookstore.bookstoreapi.model.Order;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author user
 */
public class Storage {
    
    private static final ConcurrentHashMap<String,Book>bookList=new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String,Author>authorList=new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String,Cart>cartList=new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String,Customer>customerList=new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String,Order>orderList=new ConcurrentHashMap<>();

    public static ConcurrentHashMap<String, Book> getBookList() {
        return bookList;
    }

    public ConcurrentHashMap<String, Author> getAuthorList() {
        return authorList;
    }

    public static ConcurrentHashMap<String, Cart> getCartList() {
        return cartList;
    }

    public static ConcurrentHashMap<String, Customer> getCustomerList() {
        return customerList;
    }

    public static ConcurrentHashMap<String, Order> getOrderList() {
        return orderList;
    }
    
    
        
    
    
    
    
    public String createBookId(){
        String bookId=UUID.randomUUID().toString();
        return bookId;
    }
    public String createAuthorId(){
        String authId=UUID.randomUUID().toString();
        return authId;
    }
    public String createCustomerId(){
        String custId=UUID.randomUUID().toString();
        return custId;
    }
    
    public void createNewBook(Book book ){
        String bookId=createBookId();
        book.setBookId(bookId);
        bookList.put(bookId,book);
    }
    public void createNewAuthor(Author author ){
        String authorId=createAuthorId();
        author.setAuthorId(authorId);
        authorList.put(authorId, author);
        
    }
}

