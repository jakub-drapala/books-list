package com.drapala.bookslist.controller;

import com.drapala.bookslist.model.Book;
import com.drapala.bookslist.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by maczi on 2019-04-13.
 */
@RestController
@RequestMapping(path = "/books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@CrossOrigin(origins = "http://localhost:4201")
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
    public Page<Book> getAllBooks(
            @PageableDefault Pageable page
            ) {
        return service.getBooks(page);
    }

}
