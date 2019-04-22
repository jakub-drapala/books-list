import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Book} from "./book.model";


@Injectable()
export class BookService {

  private booksUrl: string;

  constructor(private  http: HttpClient) {
    this.booksUrl = 'http://localhost:8181/books'
  }

  public getAllBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(this.booksUrl);
  }

}
