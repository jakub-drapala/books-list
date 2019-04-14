package com.drapala.bookslist.service;

import com.drapala.bookslist.model.Book;

import java.util.List;


public interface BookService {

    Book addBook(Book book);

    List<Book> getBooks();


}
