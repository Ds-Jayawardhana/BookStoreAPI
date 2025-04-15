/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.bookstore.bookstoreapi.model;

/**
 *
 * @author user
 */
public class Author {
    private String name;
    private String biography;

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
    private String authorId;

    public Author() {
    }

    public Author(String authorId,String name, String biography) {
        this.authorId=authorId;
        this.name = name;
        this.biography = biography;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
  

  
}
