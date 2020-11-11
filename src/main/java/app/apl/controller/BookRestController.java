package app.apl.controller;

import app.apl.resorce.BookRequest;
import app.apl.resorce.BookResponse;
import app.domain.service.BookService;
import core.infrastructure.model.mrs.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookRestController {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    @ResponseBody
    public List<BookResponse> getBooks(){

        return bookService.getBookList();
    }

    @GetMapping("/book")
    @ResponseBody
    public Book getBook(){

        return bookService.getBook();
    }

    @PostMapping("/book/{id}")
    public void putBook(@PathVariable("id") String id, BookRequest request){
        request.setBookId(id);
        bookService.putBook(request);

    }
}