import { Component, OnInit } from '@angular/core';
import {Book} from "../book/book.model";
import {BookService} from "../book/book.rest.service";

@Component({
  selector: 'app-books-list',
  templateUrl: './books-list.component.html',
  styleUrls: ['./books-list.component.css']
})
export class BooksListComponent implements OnInit {

  private page = 0;
  books: Book[];
  private pages: number[];

  constructor(private bookService: BookService) { }

  setPage(i, event: any) {
    event.preventDefault();
    this.page = i;
    this.getBooks();
  }

  ngOnInit() {
    this.getBooks();
  }

  getBooks() {
    this.bookService.getAllBooks(this.page).subscribe(
      data => {
        console.log(this.page);
        this.books = data['content'];
        this.pages = new Array(data['totalPages']);
      },
      (error) => {
        console.log(error.error.message);
      }
    );
  }

}
