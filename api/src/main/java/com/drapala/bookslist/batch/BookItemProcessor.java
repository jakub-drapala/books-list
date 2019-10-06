package com.drapala.bookslist.batch;

import com.drapala.bookslist.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class BookItemProcessor implements ItemProcessor<Book, Book> {

    private static final Logger log = LoggerFactory.getLogger(BookItemProcessor.class);

    @Override
    public Book process(Book book) throws Exception {
        final String name = book.getName();
        final String author = book.getAuthor();

        final Book transformedBook = new Book();

        return null;
    }
}
