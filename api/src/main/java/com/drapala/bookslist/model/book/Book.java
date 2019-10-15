package com.drapala.bookslist.model.book;

import com.drapala.bookslist.model.book.fields.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private String author;

    @Column
    private Integer publicationDate;

    @Column
    private com.drapala.bookslist.enums.Cover cover;

    public static class Builder implements Name, Author, PublicationDate, Cover, Creator {
        private String name;
        private String author;
        private Integer publicationDate;
        private com.drapala.bookslist.enums.Cover cover;

        public static Name builder() {
            return new Builder();
        }

        @Override
        public Author name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public PublicationDate author(String author) {
            this.author = author;
            return this;
        }

        @Override
        public Cover publicationDate(Integer publicationDate) {
            this.publicationDate = publicationDate;
            return this;
        }

        @Override
        public Creator cover(com.drapala.bookslist.enums.Cover cover) {
            this.cover = cover;
            return this;
        }

        @Override
        public Book build() {
            return new Book(this);
        }
    }

    private Book() {
    }

    private Book(Builder builder) {
        this.name = builder.name;
        this.author = builder.author;
        this.publicationDate = builder.publicationDate;
        this.cover = builder.cover;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
