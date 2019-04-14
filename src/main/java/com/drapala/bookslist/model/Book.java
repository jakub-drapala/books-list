package com.drapala.bookslist.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private String author;

    public Book() {
    }
}
