package com.amith.librarymanagementsystem.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Document(collection = "book")
public class Book   {
    @Id
    private int id;
    @Field(name = "book_name")
    private String bookName;
    @Field(name = "author_name")
    private String authorName;
    @Field(name = "description")
    private String description;
    @Field(name = "price")
    private String price;

    public Book(){}
    @PersistenceConstructor
    public Book(int id, String bookName, String authorName, String description, String price) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.description = description;
        this.price = price;
    }

    public Book(String bookName, String authorName, String description, String price) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.description = description;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
