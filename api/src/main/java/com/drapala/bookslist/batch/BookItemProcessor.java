package com.drapala.bookslist.batch;

import com.drapala.bookslist.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class BookItemProcessor implements ItemProcessor<String, Book> {

    private static final Logger log = LoggerFactory.getLogger(BookItemProcessor.class);

    @Override
    public Book process(String line) throws Exception {
        final String name = line;
        final String author = line;

        final Book importedBook = new Book();
        importedBook.setAuthor(name);
        importedBook.setName(author);

        return importedBook;
    }


}
