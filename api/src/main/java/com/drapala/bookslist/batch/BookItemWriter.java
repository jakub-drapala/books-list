package com.drapala.bookslist.batch;

import com.drapala.bookslist.model.Book;
import com.drapala.bookslist.service.BookService;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@StepScope
public class BookItemWriter implements ItemWriter<Book> {

    @Autowired
    BookService bookService;

    @Override
    public void write(List<? extends Book> books) throws Exception {
        books.forEach(book -> {
            bookService.addBook(book);
        });
    }
}
