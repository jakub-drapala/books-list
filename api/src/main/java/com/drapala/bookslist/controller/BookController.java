package com.drapala.bookslist.controller;

import com.drapala.bookslist.model.Book;
import com.drapala.bookslist.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by maczi on 2019-04-13.
 */
@RestController
@RequestMapping(path = "/books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BookController {


    BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return service.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return service.getBooks();
    }

}
