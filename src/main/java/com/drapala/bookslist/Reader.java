package com.drapala.bookslist;

import com.drapala.bookslist.model.Book;
import com.drapala.bookslist.repository.BookRepository;
import com.drapala.bookslist.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by maczi on 2019-04-14.
 */
@Slf4j
@Component
public class Reader implements CommandLineRunner {

    @Autowired
    BookService bookService;

    Scanner scanner = null;

    @Override
    public void run(String... strings) throws Exception {
        scanner = new Scanner(new FileReader("C:\\Users\\maczi\\Documents\\projekty\\books-list\\src\\main\\resources\\static\\books.txt"));
        scanner.useDelimiter("-");
        while (scanner.hasNextLine()) {
            String name = scanner.next();
            scanner.skip(scanner.delimiter());
            String author = scanner.nextLine();
            log.info("Imported book name: {}, author: {}", name, author);
            Book tempBook = new Book(name, author);
            bookService.addBook(tempBook);
        }

    }
}
