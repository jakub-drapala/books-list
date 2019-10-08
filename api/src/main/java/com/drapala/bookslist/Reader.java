package com.drapala.bookslist;

import com.drapala.bookslist.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by maczi on 2019-04-14.
 */
@Slf4j
@Component(value = "firstReader")
public class Reader<Book> implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Reader.class);

    @Autowired
    BookService bookService;

    @Override
    public void run(String... strings) throws Exception {
        try (BufferedReader dirFile = new BufferedReader(new FileReader("/home/jakub/Desktop/projekty/books-list/api/src/main/resources/static/books.txt"))) {
            String input;
            while ((input = dirFile.readLine()) != null) {
                String[] data = input.split("-");
                String name = data[0];
                String author = "brak";
                if (data.length > 1)
                    author = data[1];
                log.info("Imported book name: {}, author: {}", name, author);
//                Book tempBook = new Book(name, author);
//                if (!name.equals(""))
//                bookService.addBook(tempBook);
            }
        } catch (Exception e) {
            log.error("Any error");
            log.info("hello world");
            e.printStackTrace();
        }

    }
}
