import { Component, OnInit } from '@angular/core';
import {Book} from "../book/book.model";
import {BookService} from "../book/book.rest.service";

@Component({
  selector: 'app-books-list',
  templateUrl: './books-list.component.html',
  styleUrls: ['./books-list.component.css']
})
export class BooksListComponent implements OnInit {

  books: Book[];

  constructor(private bookService: BookService) { }

  ngOnInit() {
    this.bookService.getAllBooks().subscribe(data =>{
      this.books = data;
    });
  }

}
