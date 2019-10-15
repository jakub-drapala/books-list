package com.drapala.bookslist.controller;

import com.drapala.bookslist.enums.Cover;
import com.drapala.bookslist.model.book.Book;
import com.drapala.bookslist.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BookController.class, secure = false)
public class BookControllerTest extends BaseRestControllerTest {

    @MockBean
    private BookService bookService;

    private Book book;
    private Book book2;

    @Before
    @Override
    public void init() {
        book = Book.Builder.builder().name("Sample title").author("John Smith").publicationDate(2000).cover(Cover.LIMP_BINDING).build();
        book.setId(2l);

        book2 = Book.Builder.builder().name("Book2 name").author("Bryan Adams").publicationDate(1995).cover(Cover.HARDCOVER).build();
        book2.setId(5l);
    }

    @Override
    public void afterTest() {
        Mockito.verifyNoMoreInteractions(bookService);
    }

    @Test
    public void addBookTest() throws Exception {
        when(bookService.addBook(any(Book.class))).thenReturn(book);

        api.perform(post("/books").contentType(MediaType.APPLICATION_JSON_UTF8).content(json(book)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is(book.getName())));

        Mockito.verify(bookService, times(1)).addBook(any(Book.class));
    }

    @Test
    public void getAllBooksTest() throws Exception {
        when(bookService.getBooks(any(Pageable.class))).thenReturn(new PageImpl<>(Arrays.asList(book, book2)));

        api.perform(get("/books", true))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(2)))
                .andExpect(jsonPath("$.content.[1].author", is(book2.getAuthor())));

        Mockito.verify(bookService, times(1)).getBooks(any(Pageable.class));
    }
}
