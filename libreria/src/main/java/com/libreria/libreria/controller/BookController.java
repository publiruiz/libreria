package controller;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import persistencia.entity.Book;
import service.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/all")
    public List<Book> getAllBook() {
        return bookService.getAllBook();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(Integer id) {
        return bookService.getBookById(id);
    }

    @Delete("/{id}")
    public Book deleteBook(Integer id) {
        return bookService.deleteBook(id);
    }

    @Insert("/new")
    public Book insertBook(Book book) {
        return bookService.insertBook(book);
    }
}