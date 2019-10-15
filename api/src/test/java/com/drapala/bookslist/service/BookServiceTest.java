package com.drapala.bookslist.service;

import com.drapala.bookslist.TestSetup;
import com.drapala.bookslist.enums.Cover;
import com.drapala.bookslist.model.book.Book;
import com.drapala.bookslist.repository.BookRepository;
import com.drapala.bookslist.service.impl.BookServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BookServiceTest implements TestSetup {

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;

    private Book book1;
    private Book book2;

    private Page<Book> booksPage;

    @Before
    @Override
    public void init() {
        MockitoAnnotations.initMocks(this);
        book1 = Book.Builder.builder()
                .name("Pan Tadeusz")
                .author("Adam Mickiewicz")
                .publicationDate(1999)
                .cover(Cover.HARDCOVER)
                .build();
        book1.setId(1l);

        book2 = new Book.Builder()
                .name("Potop")
                .author("Henryk Sienkiewicz")
                .publicationDate(2005)
                .cover(Cover.LIMP_BINDING)
                .build();
        book2.setId(2l);

        booksPage = new PageImpl<>(Arrays.asList(book1, book2));
    }

    @Override
    public void afterTest() {
        Mockito.verifyNoMoreInteractions(bookRepository);
    }

    @Test
    public void addBookTest() {
        when(bookRepository.save(any(Book.class))).thenReturn(book1);
        Book result = bookService.addBook(book1);
        assertEquals(book1.getName(), result.getName());
        verify(bookRepository, times(1)).save(any(Book.class));
    }

    @Test
    public void getBooksTest() {
        when(bookRepository.findAll(any(Pageable.class))).thenReturn(booksPage);
        Pageable page = PageRequest.of(1, 10);
        Page<Book> result = bookService.getBooks(page);
        assertEquals(booksPage.getContent().size(), result.getContent().size());
        assertEquals(booksPage.getContent().get(1).getName(), result.getContent().get(1).getName() );
        verify(bookRepository, times(1)).findAll(any(Pageable.class));
    }
}
