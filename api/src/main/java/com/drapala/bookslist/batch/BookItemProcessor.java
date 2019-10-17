package com.drapala.bookslist.batch;

import com.drapala.bookslist.generator.DateGenerator;
import com.drapala.bookslist.model.book.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class BookItemProcessor implements ItemProcessor<String, Book> {

    private static final Logger LOG = LoggerFactory.getLogger(BookItemProcessor.class);

    @Override
    public Book process(String line) throws Exception {
        LOG.info("processing line: {}", line);

        String[] bookData = line.split("-");
        if (bookData.length < 2) return null;
        final String name = bookData[0];
        final String author = bookData[1];

        return Book.Builder.builder()
                .name(name)
                .author(author)
                .publicationDate(DateGenerator.getRandomDate())
                .cover(DateGenerator.getRandomCover())
                .build();
    }
}
