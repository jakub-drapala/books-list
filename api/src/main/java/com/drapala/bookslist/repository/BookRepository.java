package com.drapala.bookslist.repository;

import com.drapala.bookslist.model.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {


}
