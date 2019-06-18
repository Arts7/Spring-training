package com.wildcodeschool.library.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String title;
    
    private String author;

    private String description;

    public Book() {
    }

    public Book(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public Book(int id, String title, String author, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

	public void setTitle(String title2) {
        this.title = title2;
	}
    
    public void setAuthor(String author2) {
        this.author = author2;
    }
    
	public void setDescription(String description2) {
        this.description = description2;
	}

}