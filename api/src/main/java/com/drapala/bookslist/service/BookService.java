package com.drapala.bookslist.service;

import com.drapala.bookslist.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    Book addBook(Book book);

    Page<Book> getBooks(Pageable pageable);


}
