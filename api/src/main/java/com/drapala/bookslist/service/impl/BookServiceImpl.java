package com.drapala.bookslist.service.impl;

import com.drapala.bookslist.model.book.Book;
import com.drapala.bookslist.repository.BookRepository;
import com.drapala.bookslist.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by maczi on 2019-04-13.
 */

@Service
public class BookServiceImpl implements BookService {

    BookRepository repository;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book addBook(Book book) {
        return repository.save(book);
    }

    @Override
    public Page<Book> getBooks(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
