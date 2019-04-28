package com.drapala.bookslist;

import com.drapala.bookslist.model.Book;
import com.drapala.bookslist.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by maczi on 2019-04-14.
 */
@Slf4j
@Component
public class Reader implements CommandLineRunner {

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
                Book tempBook = new Book(name, author);
                if (!name.equals(""))
                bookService.addBook(tempBook);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
