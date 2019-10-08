package com.drapala.bookslist.controller;

import com.drapala.bookslist.model.Book;
import com.drapala.bookslist.service.BatchService;
import com.drapala.bookslist.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by maczi on 2019-04-13.
 */
@RestController
@RequestMapping(path = "/books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@CrossOrigin(origins = "http://localhost:4201")
public class BookController {

    private BatchService batchService;

    private BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return service.addBook(book);
    }

    @PostMapping(path = "/import")
    public void importBooks() throws Exception {
        batchService.runBatch();
    }

    @GetMapping
    public Page<Book> getAllBooks(
            @PageableDefault(size = 20) Pageable page
            ) {
        return service.getBooks(page);
    }

}
