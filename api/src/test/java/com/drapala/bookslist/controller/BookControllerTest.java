package com.drapala.bookslist.controller;

import com.drapala.bookslist.model.Book;
import com.drapala.bookslist.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@WebMvcTest(controllers = BookController.class, secure = false)
public class BookControllerTest extends BaseRestControllerTest {

    @MockBean
    private BookService bookService;

    private Book book;

    private Page<Book> booksPage;

    @Before
    @Override
    public void init() {
        book = new Book();
        book.setId(2l);
        book.setName("Sample title");
        book.setAuthor("John Smith");
    }

    @Override
    public void afterTest() {

    }


    @Test
    public void addBookTest() throws Exception {
        when(bookService.addBook(any(Book.class))).thenReturn(book);

        api.perform(post("/books").contentType(MediaType.APPLICATION_JSON).content(json(book)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is(book.getName())));
    }
}
